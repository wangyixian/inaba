package com.iidooo.cms.client.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.dto.extend.CmsContentTagDto;
import com.iidooo.cms.service.IChannelService;
import com.iidooo.cms.service.ContentService;

public class ContentAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContentAction.class);

    @Autowired
    private ContentService contentService;
    
    @Autowired
    private IChannelService channelService;
    
    private ChannelDto currentChannel;

    private ContentDto currentContent;

    private Map<String, String> tagMap;

    public ChannelDto getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(ChannelDto currentChannel) {
        this.currentChannel = currentChannel;
    }
    
    public ContentDto getCurrentContent() {
        return currentContent;
    }

    public void setCurrentContent(ContentDto currentContent) {
        this.currentContent = currentContent;
    }

    public Map<String, String> getTagMap() {
        return tagMap;
    }

    public void setTagMap(Map<String, String> tagMap) {
        this.tagMap = tagMap;
    }

    public ContentAction() {
        tagMap = new HashMap<String, String>();
    }

    @Override
    public String execute() throws Exception {
        try {
            HttpServletRequest request = this.getRequest();
            String contentID = request.getParameter(AttributeConstant.CONTENT_ID);
            if (contentID == null || contentID == "") {
                return NONE;
            }
            currentContent = contentService.getContentByID(Integer.parseInt(contentID));
            if (currentContent == null) {
                return NONE;
            }
            currentChannel = channelService.getChannelByID(currentContent.getChannelID());
            
            ServletContext sc = this.getServletContext();
//            for (CmsContentTagDto cmsTagDto : currentContent.getTags()) {
//                String classCode = cmsTagDto.getClassCode();
//                String itemCode = cmsTagDto.getItemCode();
//                String tagValue = (String)sc.getAttribute(classCode + "_" + itemCode);
//                if (tagMap.containsKey(classCode)) {                    
//                    tagMap.put(classCode,tagMap.get(classCode).concat("," + tagValue));
//                } else {
//                    tagMap.put(classCode, tagValue);
//                }
//            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

}
