package com.iidooo.cms.client.action;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.framework.action.BaseAction;

public abstract class CmsBaseAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private ChannelDto channel;

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    
    
}
