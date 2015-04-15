package com.iidooo.cms.client.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.constant.AttributeConstant;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.service.IChannelService;

public class ChannelAction extends CmsBaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(ChannelAction.class);

    @Autowired
    private IChannelService channelService;

    private ChannelDto channel;

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    @Override
    public String execute() throws Exception {
        try {
            if(channel == null || channel.getChannelPath() == null){
                channel.setChannelPath(AttributeConstant.CHANNEL_PATH_INDEX);
            }
            
            channel = channelService.getChannelByPath(channel.getChannelPath());

            if (channel == null) {
                return NONE;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e.getMessage());
            return ERROR;
        }
    }

}
