<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<
	<div class="container" style="width: 35%; padding: 50px 0px 100px 0px;">
		<h2 style="text-align: center;">ĐĂNG NHẬP</h2>
		<div class="login-form">
			<div class="main-div">
				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">Tên đăng nhập hoặc mật khẩu
						không đúng !</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">Bạn không có quyền !</div>
				</c:if>
				<form action="j_spring_security_check" id="formLogin" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="userName"
							name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="j_password" placeholder="Mật khẩu">
					</div>

					<!-- Login Google Button -->
					
					<br/><a style="background-color: #337AB7; padding: 7px 15px; color: #ffffff"
						href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/chondo/login-google&response_type=code
    &client_id=428585151574-prv9dr7n6mohebmcj57v7m0qgr0t1bp6.apps.googleusercontent.com&approval_prompt=force">Đăng
						nhập bằng google</a><br/><br/><br/>

					<button type="submit" class="btn btn-primary"
						style="text-align: center;">Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>