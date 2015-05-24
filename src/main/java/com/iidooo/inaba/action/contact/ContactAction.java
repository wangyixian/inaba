package com.iidooo.inaba.action.contact;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.core.action.BaseAction;

public class ContactAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ContactAction.class);

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
