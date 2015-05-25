package com.iidooo.inaba.action.index;

import org.apache.log4j.Logger;

import com.iidooo.cms.action.FrontBaseAction;

public class IndexAction extends FrontBaseAction {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(IndexAction.class);

    
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
