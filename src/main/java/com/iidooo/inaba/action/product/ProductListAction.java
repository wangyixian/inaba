package com.iidooo.cms.client.action.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.service.product.ProductListService;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.service.IChannelService;
import com.iidooo.cms.service.ContentService;
import com.iidooo.framework.action.PagingActionSupport;
import com.iidooo.framework.constant.DictConstant;
import com.iidooo.framework.dto.extend.DictItemDto;
import com.iidooo.framework.service.DictItemService;

public class ProductListAction extends PagingActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ProductListAction.class);

    @Autowired
    private DictItemService dictItemService;

    @Autowired
    private IChannelService channelService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ProductListService productListService;

    private ContentProductDto product;

    public ContentProductDto getProduct() {
        return product;
    }

    public void setProduct(ContentProductDto product) {
        this.product = product;
    }

    private List<DictItemDto> productTypes;

    private List<DictItemDto> productCountries;

    private List<DictItemDto> productOrigins;

    private List<ContentProductDto> products;

    private ChannelDto channel;

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public List<DictItemDto> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<DictItemDto> productTypes) {
        this.productTypes = productTypes;
    }

    public List<DictItemDto> getProductCountries() {
        return productCountries;
    }

    public void setProductCountries(List<DictItemDto> productCountries) {
        this.productCountries = productCountries;
    }

    public List<DictItemDto> getProductOrigins() {
        return productOrigins;
    }

    public void setProductOrigins(List<DictItemDto> productOrigins) {
        this.productOrigins = productOrigins;
    }

    public List<ContentProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ContentProductDto> products) {
        this.products = products;
    }

    public String init() {
        try {

            channel = channelService.getChannelByID(channel.getChannelID());

            // The first time execute, product is null and set the default value.
            if (product == null) {
                product = new ContentProductDto();
                product.setProductCountry("0");
                product.setProductOrigin("0");
                product.setProductType("0");
            }
            
            // Get the Product Extend Field Info
            List<String> dictClassCodes = new ArrayList<String>();
            dictClassCodes.add(DictConstant.FIELD_PRODUCT_TYPE);
            dictClassCodes.add(DictConstant.FIELD_PRODUCT_ORIGIN);
            dictClassCodes.add(DictConstant.FIELD_PRODUCT_COUNTRY);
            List<DictItemDto> dictItems = dictItemService.getByClassCode(dictClassCodes);

            productCountries = new ArrayList<DictItemDto>();
            productOrigins = new ArrayList<DictItemDto>();
            productTypes = new ArrayList<DictItemDto>();

            for (DictItemDto item : dictItems) {
                switch (item.getDictClassCode()) {
                case DictConstant.FIELD_PRODUCT_TYPE:
                    productTypes.add(item);
                    break;
                case DictConstant.FIELD_PRODUCT_ORIGIN:
                    productOrigins.add(item);
                    break;
                case DictConstant.FIELD_PRODUCT_COUNTRY:
                    productCountries.add(item);
                    break;
                }
            }

            // Get all of the clicked channel's offspring channels.
            List<ChannelDto> offspringChannels = channelService.getOffspringChannels(channel.getChannelID(), true);
            int recordSum = productListService.searchCount(offspringChannels, product);
            this.executePaging(recordSum);
             products = productListService.search(offspringChannels, product, this.getPagingDto());

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
