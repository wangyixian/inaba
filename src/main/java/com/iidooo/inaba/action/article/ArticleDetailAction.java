package com.iidooo.inaba.action.article;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.core.action.BaseAction;

public class ArticleDetailAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ArticleDetailAction.class);

    @Autowired
    private ContentArticleService contentArticleService;

    private CmsContentArticleDto content;

    public CmsContentArticleDto getContent() {
        return content;
    }

    public void setContent(CmsContentArticleDto content) {
        this.content = content;
    }

    public String init() {
        try {
            content = contentArticleService.getContentByID(content.getContentID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
