<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="cms" uri="/cms-api-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Head.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/inaba/css/article/ArticleList.css">
<cms:metaInfo siteCode="inaba" channelPath="articleList" />
</head>
<body>
	<form id="form" action="" method="post">
		<jsp:include page="../include/Top.jsp"></jsp:include>
		<div id="news" class="page_content_wrap">
			<cms:channelMenu siteCode="inaba" channelPath="articleList" />
			<div>
				<div class="left_block_wrap">
					<cms:contentListBlock siteCode="inaba" id="blog" title="热门文章" channelPath="blog" action="articleDetail.action" isShowDate='true' />
					<cms:contentListBlock siteCode="inaba" id="news" title="热点新闻" channelPath="news" action="articleDetail.action" isShowDate='true' />
					<cms:contentListBlock siteCode="inaba" id="konwledge" title="葡萄酒知识" channelPath="konwledge" action="articleDetail.action" isShowDate='true' />
				</div>
				<div class="right_block_wrap">
					<div class="block">
						<ul>
							<s:iterator value="contentList" id="item" status="st">
								<li><s:if test="#st.first">
										<div class="top_blog">
											<div class="blog_title">
												<a href="articleDetail.action?content.contentID=${item.contentID }" target='_blank'>${item.contentTitle}</a>
											</div>
											<div class="blog_date">${item.updateDate}|${item.createUserName}</div>
											<div class="blog_image">
												<a href="articleDetail.action?content.contentID=${item.contentID }" target='_blank'> <img alt="${item.contentTitle}"
													src="${CONTENT_RES_ROOT}${item.contentImageTitle}">
												</a>
											</div>
											<div class="blog_summary">${item.contentSummary}</div>
										</div>
									</s:if> <s:else>
										<div class="blog">
											<div class="left">
												<div class="blog_title">
													<a href="articleDetail.action?content.contentID=${item.contentID }" target='_blank'>${item.contentTitle}</a>
												</div>
												<div class="blog_date">${item.updateDate}|${item.createUserName}</div>
												<div class="blog_summary">${item.contentSummary}</div>
											</div>
											<div class="right">
												<div>
													<a href="articleDetail.action?content.contentID=${item.contentID }"> <img alt="${item.contentTitle}"
														src="${CONTENT_RES_ROOT}${item.contentImageTitle}">
													</a>
												</div>
											</div>
										</div>
									</s:else></li>
							</s:iterator>
						</ul>
					</div>
					<jsp:include page="../include/Paging.jsp"></jsp:include>
				</div>
			</div>
		</div>
		
		<jsp:include page="../include/Footer.jsp"></jsp:include>
	</form>
</body>
</html>