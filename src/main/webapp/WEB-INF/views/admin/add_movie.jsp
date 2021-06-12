<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- sử dụng taglibs của spring để bind-data từ end-point trả về. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- tích hợp jstl vào jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<meta name="description"
	content="Xem phim mới miễn phí nhanh chất lượng cao. Xem Phim online Việt Sub, Thuyết minh, lồng tiếng chất lượng HD. Xem phim nhanh online chất lượng cao" />
<meta name="keywords"
	content="HTML, CSS, JavaScript, Java, Spring, MySql, Maven" />
<meta name="author" content="CuongPham">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- FAVICONS -->
<%@ include file="/WEB-INF/views/layout/favicons.jsp"%>
<!-- -------- -->

<!-- CSS & JAVA_SCRIPT -->
<%@ include file="/WEB-INF/views/layout/includer.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/manage.css">
<!-- ----------------- -->

<title>Movie Project</title>
</head>

<body>
	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v5.0"></script>

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
										<strong>Success!</strong> Bạn đã thêm phim thành công!
									</div>
								</c:when>
								<c:when test="${status=='faile'}">
									<div class="alert alert-danger">
										<strong>Faile!</strong> Bạn đã thêm phim thất bại!

									</div>
								</c:when>
							</c:choose>

							<div class="card-body">
								<div class="panel-body">
									<form:form modelAttribute="phim" action="/user/add-movie">
										<div class="form-group">
											<label class="required" for="txtInput">Hình thức:</label>
											<form:select class="form-control" path="hinhThuc.id">
												<form:options items="${hinhThucRepositories }"
													itemValue="id" itemLabel="ten_loai" />
											</form:select>
										</div>
										<div class="form-group">
											<label class="required">Tên phim Tiếng Việt:</label>
											<form:input path="ten_phim_tiengviet" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Tên phim Tiếng Anh:</label>
											<form:input path="ten_phim_tienganh" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Điểm IMDb:</label>
											<form:input path="diem_IMDb" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Đạo diễn:</label>
											<form:input path="dao_dien" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Quốc gia:</label>
											<form:input path="quoc_gia" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Năm:</label>
											<form:input path="nam" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Thời lượng:</label>
											<form:input path="thoi_luong" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Số tập:</label>
											<form:input path="so_tap" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Chất lượng:</label>
											<form:input path="chat_luong" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Thể loại:</label>
											<form:input path="the_loai" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Nội dung phim:</label>
											<form:textarea path="noi_dung_phim" class="form-control"
												rows="5" id="summernote"></form:textarea>
										</div>
										<div class="form-group">
											<label class="required">Công ty SX:</label>
											<form:input path="congty_sx" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Trailer:</label>
											<form:input path="trailer" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Id Google Drive:&ensp;</label><br>
											<textarea style="width: 100%" name="idPosterVideo" rows="5"></textarea>
										</div>
										<button type="submit" class="btn btn-success">
											<i class="fas fa-download"></i> Save
										</button>
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