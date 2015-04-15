package com.iidooo.cms.client.action.index;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.action.CmsBaseAction;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.cms.service.ContentProductService;
import com.iidooo.cms.service.ContentService;

public class IndexAction extends CmsBaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(IndexAction.class);

    @Autowired
    private ContentService contentService;

    private List<ContentDto> choiceProducts;

    private List<ContentDto> salesProducts;

    private List<ContentDto> lastestArticles;

    public List<ContentDto> getChoiceProducts() {
        return choiceProducts;
    }

    public void setChoiceProducts(List<ContentDto> choiceProducts) {
        this.choiceProducts = choiceProducts;
    }

    public List<ContentDto> getSalesProducts() {
        return salesProducts;
    }

    public void setSalesProducts(List<ContentDto> salesProducts) {
        this.salesProducts = salesProducts;
    }

    public List<ContentDto> getLastestArticles() {
        return lastestArticles;
    }

    public void setLastestArticles(List<ContentDto> lastestArticles) {
        this.lastestArticles = lastestArticles;
    }

    public String init() {
        try {
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
