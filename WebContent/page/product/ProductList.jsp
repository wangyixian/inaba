<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="core" uri="/core-api-tags"%>
<%@ taglib prefix="cms" uri="/cms-api-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/Head.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/inaba/css/product/ProductList.css">
<cms:metaInfo siteCode="inaba" channelPath="productList" />

<script type="text/javascript">
	function searchByCountry(productCountry){
		$("#hidProductCountry").val(productCountry);
		window.form.submit();
	}
	
	function searchByOrigin(productOrigin){
		$("#hidProductOrigin").val(productOrigin);
		window.form.submit();
	}
	
	function searchByType(productType){
		$("#hidProductType").val(productType);
		window.form.submit();
	}
</script>
</head>
<body>
	<form id="form" action="productList" method="post">
		<input id="hidProductCountry" type="hidden" name="product.productCountry" value="${product.productCountry }">
	    <input id="hidProductOrigin" type="hidden" name="product.productOrigin" value="${product.productOrigin }">
	    <input id="hidProductType" type="hidden" name="product.channelPath" value="${product.channelPath }">
	    
		<jsp:include page="../include/Top.jsp"></jsp:include>
	    <div class="page_content_wrap">	    	
	    	<cms:channelMenu siteCode="inaba" channelPath="productList" />
	    	<div id="classify" class="block frame">
		    	<dl>
		    		<dt>国家：</dt>
		    		<dd>
		    			<div>
		    				<core:dictItemList id="productCountry" value="product.productCountry" dictClassCode="DICT_CLASS_INABA_COUNTRY" onClick="searchByCountry(dictItemCode)"/>
		    			</div>
		    		</dd>
		    	</dl>	
		    	<dl>
		    		<dt>产地：</dt>
		    		<dd>
		    			<div>
		    				<core:dictItemList id="productOrigin" value="product.productOrigin" dictClassCode="DICT_CLASS_INABA_ORIGIN" onClick="searchByOrigin(dictItemCode)"/>
		    			</div>
		    		</dd>
		    	</dl>	
		    	<dl>
		    		<dt>分类：</dt>
		    		<dd>
		    			<div>		    				
							<cms:channelList siteCode="inaba" parentPath="productList" id="productList" value="product.productType" onClick="searchByType(channelID)"/>
		    			</div>
		    		</dd>
		    	</dl>    	
	    	</div>
			<div id="products" class="block">
				<ul>
					<s:iterator value="productList" status="st" id="item">	
					<li class="left">
						<div>
							<a href="productDetail.action?content.contentID=${item.contentID }" target="_blank">
							<img class="image_title" alt="${item.contentTitle}" src="${item.contentImageTitle}">
							</a>
						</div>
						<div class="align_center">
							<a href="productDetail.action?content.contentID=${item.contentID }" target="_blank">${item.contentTitle}</a>
						</div>
					</li>
					</s:iterator>
				</ul>
			</div>
			<jsp:include page="../include/Paging.jsp"></jsp:include>
		</div>
	    <jsp:include page="../include/Footer.jsp"></jsp:include>
    </form>
</body>
</html>