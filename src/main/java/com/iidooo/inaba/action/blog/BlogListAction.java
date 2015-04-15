package com.iidooo.cms.client.action.blog;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iidooo.cms.client.service.blog.BlogListService;
import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.CmsContentArticleDto;
import com.iidooo.cms.dto.extend.ContentDto;
import com.iidooo.cms.service.IChannelService;
import com.iidooo.cms.service.ContentService;
import com.iidooo.framework.action.PagingActionSupport;

public class BlogListAction extends PagingActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(BlogListAction.class);

    @Autowired
    private IChannelService channelService;

    @Autowired
    private ContentService contentService;

    private ChannelDto channel;

    public ChannelDto getChannel() {
        return channel;
    }

    public void setChannel(ChannelDto channel) {
        this.channel = channel;
    }

    private List<ContentDto> articles;

    public List<ContentDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ContentDto> articles) {
        this.articles = articles;
    }

    public String init() {
        try {
            channel = channelService.getChannelByID(channel.getChannelID());
            List<ChannelDto> channels = channelService.getOffspringChannels(channel.getChannelID(), true);
            int recordSum = contentService.getChannelContentsCount(channels);
            this.executePaging(recordSum, 10);
            articles = contentService.getChannelContents(channels, this.getPagingDto());
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            return ERROR;
        }
    }
}
