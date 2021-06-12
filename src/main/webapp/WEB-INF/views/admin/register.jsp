<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- sử dụng taglibs của spring để bind-data từ end-point trả về. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- tích hợp jstl vào jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="description"
	content="ban laptop uy tin, chat luong, dich vu tot">
<meta name="keywords"
	content="laptop, asus, dell, hp, lenovo, acer, apple, msi, lg">
<meta name="author" content="CuongPham">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS & JAVA_SCRIPT -->
<%@ include file="/WEB-INF/views/layout/includer.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/manage.css">
<!-- ----------------- -->

<title>Laptop Project</title>
</head>

<body>

	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v8.0"
		nonce="ChmFo6ST"></script>

	<!-- MAIN -->
	<div id="main">
		<div class="sidebar">
			<div class="sidebar-inner">
				<div class="sidebar-logo">
					<a class="sidebar-link" href="/"> <img class="icon"
						src="/img/logo.png">
					</a>
				</div>

				<nav class="navbar scrollbar" id="style-1">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/user/manage"><i
								class="fas fa-home"></i>Dashboard</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle tables" href="#" id="navbardrop"
							data-toggle="dropdown"><i class="fas fa-list"></i>Tables</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/admin/list-user">Account</a> <a
									class="dropdown-item" href="/user/list-movie">Movie</a>
							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle forms" href="#" id="navbardrop"
							data-toggle="dropdown"><i class="fas fa-pencil-alt"></i></i>Forms</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/admin/add-user">Account</a> <a
									class="dropdown-item" href="/user/add-movie">Movie</a>
							</div></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-envelope"></i>Email</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-map"></i>Maps</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="far fa-comment-dots"></i>Chat</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="far fa-calendar-alt"></i>Calendar</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-chart-bar"></i>Charts</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="far fa-copy"></i>Pages</a></li>

					</ul>

				</nav>
			</div>
		</div>
		<div class="page-container">
			<div class="header-container">
				<nav class="navbar">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"> <img class="icon"
								src="/img/anh-dai-dien-1.jpg"> <span class="text-icon">${userDis.username }</span>
						</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/user/user-details"><i
									class="far fa-user"></i>Profile</a> <a class="dropdown-item"
									href="/logout"><i class="fas fa-power-off"></i>Logout</a>
							</div></li>
					</ul>
				</nav>
			</div>

			<div class="main-content">
				<div class="row">
					<div class="col-md-12">
						<div class="form-add">
							<c:choose>
								<c:when test="${status=='success'}">
									<div class="alert alert-success">
										<strong>Success!</strong> Bạn đã gửi thông tin thành công!
									</div>
								</c:when>
								<c:when test="${status=='faile'}">
									<div class="alert alert-danger">
										<strong>Faile!</strong> Bạn gửi thông tin thất bại!
									</div>
								</c:when>
							</c:choose>
							<div class="card-body">
								<div class="panel-body">
									<form:form modelAttribute="userInfo" action="/admin/add-user">
										<div class="form-group">
											<c:choose>
												<c:when test="${status=='faileNameNotNull'}">
													<div class="alert alert-danger">
														<strong>Faile!</strong> Họ tên không được để trống!
													</div>
												</c:when>
											</c:choose>
											<label class="required">Họ tên:</label>
											<form:input path="fullname" class="form-control"
												placeholder="Nhập họ tên" />
										</div>
										<div class="form-group">
											<c:choose>
												<c:when test="${status=='faileEmailNotFormat'}">
													<div class="alert alert-danger">
														<strong>Faile!</strong> Email không đúng định dạng!
													</div>
												</c:when>
											</c:choose>
											<label class="required">E-mail:</label>
											<form:input path="email" class="form-control"
												placeholder="Nhập email" />
										</div>
										<div class="form-group">
											<c:choose>
												<c:when test="${status=='faileMobileNotFormat'}">
													<div class="alert alert-danger">
														<strong>Faile!</strong> Số điện thoại không đúng định
														dạng!
													</div>
												</c:when>
											</c:choose>
											<label class="required">Số điện thoại:</label>
											<form:input path="mobile" class="form-control"
												placeholder="Nhập số điện thoại" />
										</div>
										<div class="form-group">
											<c:choose>
												<c:when test="${status=='faileTenBiTrung'}">
													<div class="alert alert-danger">
														<strong>Faile!</strong> Tên tài khoản đã được sử dụng!
													</div>
												</c:when>
												<c:when test="${status=='faileTenUserNotNull'}">
													<div class="alert alert-danger">
														<strong>Faile!</strong> Tên tài khoản không được để trống!
													</div>
												</c:when>
											</c:choose>
											<label class="required">Tên tài khoản:</label>
											<form:input path="username" class="form-control"
												placeholder="Nhập tên tài khoản" />
										</div>
										<div class="form-group">
											<c:choose>
												<c:when test="${status=='failePassNotNull'}">
													<div class="alert alert-danger">
														<strong>Faile!</strong> Mật khẩu không được để trống!
													</div>
												</c:when>
											</c:choose>
											<label class="required">Mật khẩu:</label>
											<form:input path="password" class="form-control"
												placeholder="Nhập mật khẩu" />
										</div>

										<div class="card-body">
											<button type="submit" class="btn btn-success">
												<i class="fas fa-download"></i> Submit
											</button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="footer">
				©
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<fmt:formatDate pattern="yyyy" value="${now}" />
				Copyright: <a href="https://www.facebook.com/cuongphamptit999/">
					CuongPham.com</a>
			</div>

		</div>
	</div>
	<!-- ---- -->

</body>


</html>
