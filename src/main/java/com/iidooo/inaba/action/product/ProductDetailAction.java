package com.iidooo.inaba.action.product;

import org.apache.log4j.Logger;

import com.iidooo.cms.api.action.SiteSupportAction;
import com.iidooo.inaba.constant.InabaConstant;

public class ProductDetailAction extends SiteSupportAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ProductDetailAction.class);

    public String init() {
        try {
            this.sendGetChannelAPI(InabaConstant.SITE_CODE, this.getChannel().getChannelPath());
            this.sendGetContentProductAPI(this.getContent().getContentID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
