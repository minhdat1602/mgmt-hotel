<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.chondo.util.SecurityUtils"%>
<%@page import="com.chondo.util.PriceUtil"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Booking</title>

</head>
<body>
	<!--Room Section Title start-->
	<div class="room-section text-center ptb-80 white_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-title mb-75">
						<h2>
							Our <span>room</span>
						</h2>
						<p>There are many variations of passages of Lorem Ipsum
							available, but the majority have suffered by injected humour.</p>
					</div>
				</div>
			</div>
			<div class="our-room-show">
				<div class="row">
					<div class="our-room-list owl-pagination">
						<div class="single-room-sapce">
							<!-- LIST -->
							<c:forEach items="${rooms}" var="roomType">
								<div class="col-md-4 hidden-sm col-xs-12">
									<div class="single-room">
										<div class="room-img">
											<a href="#"><img
												src="<c:url value='/template/web/images/room/${roomType.image}'/>"
												alt=""></a>
										</div>
										<div class="room-desc">
											<div class="room-name">
												<h3>
													<a href="#">${roomType.name }</a>
												</h3>
											</div>
											<div class="room-rent">
												<h5>${PriceUtil.convert(roomType.sellPrice)}
													đ/ <span>Đêm</span>
												</h5>
											</div>
											<div class="room-book">
												<a
													href="<c:url value='http://localhost:8080/chondo/tim-kiem?dateFrom=24/12/2021&dateTo=25/12/2021&adult=1&children=0&roomCount=1&location=V%C5%A9ng+T%C3%A0u&page=1&limit=2&roomTypeId=${roomType.id}'/>">Book
													ngay</a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Room Section end-->

</body>
</html>