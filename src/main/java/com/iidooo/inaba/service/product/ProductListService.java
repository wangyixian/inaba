package com.iidooo.cms.client.service.product;

import java.util.List;

import com.iidooo.cms.dto.extend.ChannelDto;
import com.iidooo.cms.dto.extend.ContentProductDto;
import com.iidooo.framework.dto.base.PagingDto;

public interface ProductListService {
    int searchCount(List<ChannelDto> channels, ContentProductDto product);

    List<ContentProductDto> search(List<ChannelDto> channels, ContentProductDto product, PagingDto page);
}
