package com.iidooo.inaba.action.product;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.core.action.BaseAction;

public class ProductDetailAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ProductDetailAction.class);

    @Autowired
    private ContentProductService contentProductService;

    private ContentProductDto content;

    public ContentProductDto getContent() {
        return content;
    }

    public void setContent(ContentProductDto content) {
        this.content = content;
    }

    public String init() {
        try {
            content = contentProductService.getContentByID(content.getContentID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
