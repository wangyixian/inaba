package com.iidooo.cms.client.service.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iidooo.cms.dao.extend.ContentProductDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.framework.dto.base.PagingDto;

@Service
public class ProductListServiceImpl implements ProductListService{
    private static final Logger logger = Logger.getLogger(ProductListServiceImpl.class);

    @Autowired
    private ContentProductDao contentProductDao;
    
    @Override
    public int searchCount(List<ChannelDto> channels, ContentProductDto product) {
        int count = 0;
        try {
            count = contentProductDao.selectProductsCount(channels, product);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return count;
    }

    @Override
    public List<ContentProductDto> search(List<ChannelDto> channels, ContentProductDto product, PagingDto page) {
        List<ContentProductDto> contentProducts = new ArrayList<ContentProductDto>();
        try {
            contentProducts = contentProductDao.selectProducts(channels, product, page);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
        return contentProducts;
    }
}
