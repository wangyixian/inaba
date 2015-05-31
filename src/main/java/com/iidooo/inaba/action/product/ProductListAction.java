package com.iidooo.inaba.action.product;

import org.apache.log4j.Logger;

import com.iidooo.core.action.BaseAction;

public class ProductListAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ProductListAction.class);

//    @Autowired
//    private DictItemService dictItemService;
//
//    @Autowired
//    private IChannelService channelService;
//
//    @Autowired
//    private ContentService contentService;
//
//    @Autowired
//    private ProductListService productListService;
//
//    private ContentProductDto product;
//
//    public ContentProductDto getProduct() {
//        return product;
//    }
//
//    public void setProduct(ContentProductDto product) {
//        this.product = product;
//    }
//
//    private List<DictItemDto> productTypes;
//
//    private List<DictItemDto> productCountries;
//
//    private List<DictItemDto> productOrigins;
//
//    private List<ContentProductDto> products;
//
//    private ChannelDto channel;
//
//    public ChannelDto getChannel() {
//        return channel;
//    }
//
//    public void setChannel(ChannelDto channel) {
//        this.channel = channel;
//    }
//
//    public List<DictItemDto> getProductTypes() {
//        return productTypes;
//    }
//
//    public void setProductTypes(List<DictItemDto> productTypes) {
//        this.productTypes = productTypes;
//    }
//
//    public List<DictItemDto> getProductCountries() {
//        return productCountries;
//    }
//
//    public void setProductCountries(List<DictItemDto> productCountries) {
//        this.productCountries = productCountries;
//    }
//
//    public List<DictItemDto> getProductOrigins() {
//        return productOrigins;
//    }
//
//    public void setProductOrigins(List<DictItemDto> productOrigins) {
//        this.productOrigins = productOrigins;
//    }
//
//    public List<ContentProductDto> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<ContentProductDto> products) {
//        this.products = products;
//    }
//
//    public String init() {
//        try {
//
//            channel = channelService.getChannelByID(channel.getChannelID());
//
//            // The first time execute, product is null and set the default value.
//            if (product == null) {
//                product = new ContentProductDto();
//                product.setProductCountry("0");
//                product.setProductOrigin("0");
//                product.setProductType("0");
//            }
//            
//            // Get the Product Extend Field Info
//            List<String> dictClassCodes = new ArrayList<String>();
//            dictClassCodes.add(DictConstant.FIELD_PRODUCT_TYPE);
//            dictClassCodes.add(DictConstant.FIELD_PRODUCT_ORIGIN);
//            dictClassCodes.add(DictConstant.FIELD_PRODUCT_COUNTRY);
//            List<DictItemDto> dictItems = dictItemService.getByClassCode(dictClassCodes);
//
//            productCountries = new ArrayList<DictItemDto>();
//            productOrigins = new ArrayList<DictItemDto>();
//            productTypes = new ArrayList<DictItemDto>();
//
//            for (DictItemDto item : dictItems) {
//                switch (item.getDictClassCode()) {
//                case DictConstant.FIELD_PRODUCT_TYPE:
//                    productTypes.add(item);
//                    break;
//                case DictConstant.FIELD_PRODUCT_ORIGIN:
//                    productOrigins.add(item);
//                    break;
//                case DictConstant.FIELD_PRODUCT_COUNTRY:
//                    productCountries.add(item);
//                    break;
//                }
//            }
//
//            // Get all of the clicked channel's offspring channels.
//            List<ChannelDto> offspringChannels = channelService.getOffspringChannels(channel.getChannelID(), true);
//            int recordSum = productListService.searchCount(offspringChannels, product);
//            this.executePaging(recordSum);
//             products = productListService.search(offspringChannels, product, this.getPagingDto());
//
//            return SUCCESS;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.fatal(e);
//            return ERROR;
//        }
//    }
}
