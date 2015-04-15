package com.iidooo.cms.client.action.recruit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.action.CmsBaseAction;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.IChannelService;
import com.iidooo.cms.service.ContentService;

public class RecruitAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(RecruitAction.class);

    @Autowired
    private IChannelService channelService;

    @Autowired
    private ContentService contentService;

    private ChannelDto channel;

    private ContentDto content;

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    public ContentDto getContent() {
        return content;
    }

    public void setContent(ContentDto content) {
        this.content = content;
    }

    public String init() {
        try {
            this.channel = channelService.getChannelByID(channel.getChannelID());
            this.content = contentService.getContentByChannel(channel.getChannelID());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }

}
