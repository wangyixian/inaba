package com.iidooo.inaba.action.product;

import org.apache.log4j.Logger;

import com.iidooo.cms.api.action.SiteSupportAction;
import com.iidooo.inaba.constant.InabaConstant;

public class ProductListAction extends SiteSupportAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ProductListAction.class);

    public String init() {
        try {
            this.sendGetProductListAPI(InabaConstant.SITE_CODE, this.getActionName(), this.getProduct());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
