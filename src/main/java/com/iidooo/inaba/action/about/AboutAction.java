package com.iidooo.inaba.action.about;

import org.apache.log4j.Logger;

import com.iidooo.cms.api.action.SiteSupportAction;
import com.iidooo.inaba.constant.InabaConstant;

public class AboutAction extends SiteSupportAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(AboutAction.class);

    public String init() {
        try {
            this.sendGetContentAPI(InabaConstant.SITE_CODE, this.getActionName());

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

}
