package com.iidooo.inaba.action.article;

import org.apache.log4j.Logger;

import com.iidooo.cms.api.action.SiteSupportAction;
import com.iidooo.inaba.constant.InabaConstant;

public class ArticleDetailAction extends SiteSupportAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ArticleDetailAction.class);

    public String init() {
        try {
            this.sendGetChannelAPI(InabaConstant.SITE_CODE, this.getChannel().getChannelPath());
            this.sendGetContentAPI(this.getContent().getContentID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
