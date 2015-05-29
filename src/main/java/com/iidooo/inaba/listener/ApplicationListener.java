package com.iidooo.inaba.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.iidooo.cms.constant.CmsConstant;

public class ApplicationListener extends HttpServlet implements ServletContextListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ApplicationListener.class);

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void contextInitialized(ServletContextEvent arg0) {
        try {
            ServletContext sc = arg0.getServletContext();
            String cmsURL = sc.getInitParameter(CmsConstant.CMS_URL);
            sc.setAttribute(CmsConstant.CMS_URL, cmsURL);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }
}
