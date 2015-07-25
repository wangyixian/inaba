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
				<cms:contentSlideBlock siteCode="inaba" channelPath="productList" action="productDetail" title="精品展示" id="nominate"/>
			</div>
			<div class="right_block_wrap">
				<cms:contentListBlock id="info" action="articleDetail" siteCode="inaba" channelPath="articleList" title="最新资讯" isShowDate='true' />
			</div>
		</div>
		<div>
    		<div>
    			<cms:contentListBlock id="sales" action="productDetail" siteCode="inaba" channelPath="productList" title="热销红酒" isShowImage="true" pageSize='8' sortField="PageViewed"/>
    		</div>
    	</div>
	</div>
    <jsp:include page="page/include/Footer.jsp"></jsp:include>
</body>

</html>