<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.chondo.util.SecurityUtils"%>
<%@page import="com.chondo.util.PriceUtil"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Khóa</title>
</head>
<body>

	<form id="formSubmit" action="<c:url value = "/quan-tri/khoa"/>">

		<!-- 	<input id="page" type="hidden" name="page" /> <input id="limit"
			type="hidden" name="limit" /> -->

		<h3>Danh sách Khóa</h3>

		<div class="scrollDiv">
			<table class="table text-center">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Cặp Khóa</th>
		
						<th scope="col">Tùy Chỉnh</th>
					</tr>
				</thead>
				<tbody class="scrollDiv">
					<c:forEach items="${keyPairs}" var="keyPair">
						<tr>
							<td style="line-height: 60px;">${keyPair.id}</td>
							<td style="line-height: 20px;">
								<div class= "copy-text" style="margin-bottom: 3px;">Khóa riêng tư:&nbsp;&nbsp;&nbsp;&nbsp; <input id="val" type="text" value="${keyPair.privateKey}"> <button onclick="clipboard()"><i class="fa fa-clone"></i></button></div>
								<div class = "copy-text">Khóa công khai: <input id="val" type="text" value="${keyPair.publicKey}"> <button onclick="clipboard()"><i class="fa fa-clone"></i></button></div>
							</td>
							<td style="line-height: 60px;"><a
								href="<c:url value ="/quan-tri/khoa/xoa?id=${keyPair.id}"/>">Xóa</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<hr>
			<div class="btn-control ml-2 mb-2">
				<a style="color: white; text-decoration: none;"
					href="<c:url value ="/quan-tri/khoa/phat-sinh"/>"
					type="button" class="btn btn-info"> Phát sinh khóa <i
					class="fa fa-plus ml-2"></i>
				</a>
			</div>
		</div>
		<%-- 
		<ul id="pagination-demo" class="pagination-lg"></ul>
		--%>
	</form>


	<%-- 	
	<script
		src="<c:url value = "/template/pagination/jquery.twbsPagination.js" />"></script>
	<script type="text/javascript">
		var totalPage = $
		{
			model.totalPage
		};
		var currentPage = $
		{
			model.page
		};
		var limit = $
		{
			model.limit
		};
		$('#pagination-demo').twbsPagination({
			totalPages : totalPage,
			visiblePages : 5,
			startPage : currentPage,
			onPageClick : function(event, page) {
				$('#searchInput').attr('name', '');
				if (page != currentPage) {
					$('#page').val(page);
					$('#limit').val(limit);
					$('#formSubmit').submit();
				}
			}
		});
	</script> 
--%>
		<script>
			function clipboard(){
				var val = document.getElementById("val");
				val.select();
				document.execCommand('copy');
			}
		</script>

</body>
</html>