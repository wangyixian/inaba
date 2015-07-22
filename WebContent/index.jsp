<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="cms" uri="/cms-api-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="page/include/Head.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/inaba/css/index/Index.css">
<cms:metaInfo siteCode="inaba" channelPath="index"/>
</head>
<body>
	<jsp:include page="page/include/Top.jsp"></jsp:include>
	<div class="page_content_wrap">
		<cms:channelMenu siteCode="inaba" channelPath="index" />
    	<div id="banner" class="banner"><img src="/inaba/img/index/banner.png"></div>
    	<div>
			<div class="left_block_wrap">
				<cms:contentSlideBlock siteCode="inaba" channelPath="productList" action="productDetail" title="精品展示" id="nominate" pageSize="5" sortField="UniqueVisitor"/>
			</div>
			<div class="right_block_wrap">
				<div id="info" class="block">
					<div class="block_title">
						<a class="main_title">最新资讯</a>
					</div>
					<div class="block_content">					
    					<ul>
    						<cms:contentList siteCode="inaba" channelPath='news' action='articleDetail' isShowDate='true' sortField='UpdateTime' sortType='desc' pageStart='0' pageSize='10'/>
    					</ul>
					</div>
				</div>				
			</div>
		</div>
		<div>
    		<div>
    			<div id="sales" class="block">
    				<div class="block_title">
    					<a class="main_title">
    						热销红酒
    						<span class="mark_top"></span>
    						<span class="mark_bottom"></span>
    					</a>
    				</div>
    				<div class="block_content">
    					<ul class="product_list">
							<cms:contentList siteCode="inaba" channelPath="productList" action='productDetail' isShowImage="true" pageStart='0' pageSize='8' sortField="PageViewed" sortType="desc"/>
    					</ul>
    				</div>
    			</div>
    		</div>
    	</div>
	</div>
    <jsp:include page="page/include/Footer.jsp"></jsp:include>
</body>

<script type="text/javascript" src="${CMS_URL }/js/slide_scroll.js"></script>
</html>