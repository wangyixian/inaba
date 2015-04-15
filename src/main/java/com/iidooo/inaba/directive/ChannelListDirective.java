package com.iidooo.cms.client.directive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iidooo.cms.constant.FreemarkerConstant;
import com.iidooo.cms.dao.extend.ChannelDao;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.framework.utility.FreeMarkerUtil;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class ChannelListDirective implements TemplateDirectiveModel {

    private static final Logger logger = Logger.getLogger(ChannelListDirective.class);

    @Autowired
    private ChannelDao cmsChannelDao;

    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException,
            IOException {
        try {
            Map<String, Object> daoParams = FreeMarkerUtil.convertDirectiveParams(params);
            List<ChannelDto> cmsChannelDtos = new ArrayList<ChannelDto>();
            String level = (String) daoParams.get(FreemarkerConstant.PARAM_CHANNEL_PARENT_ID);
            if (level.equals("0")) {
                cmsChannelDtos = cmsChannelDao.selectByParentID(0);
            }

            FreeMarkerUtil.setDirectiveResult(cmsChannelDtos, FreemarkerConstant.RETURN_LIST, env, body);
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }

    }

}
