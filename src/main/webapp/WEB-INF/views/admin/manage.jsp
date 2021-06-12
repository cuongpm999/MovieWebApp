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
						<div class="table-product scrollbar1" id="style-1">
							<table class="table">
								<thead style="background-color: #03a9f4; color: white;">
									<tr>
										<th>Tên phim</th>
										<th>Lượt xem</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="listMovieRP" items="${listMovieRP }">
										<tr>
											<td>${listMovieRP.ten_phim_tienganh }</td>
											<td>${listMovieRP.luot_xem }</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-6">
						<iframe
							src="https://calendar.google.com/calendar/embed?height=600&amp;wkst=1&amp;bgcolor=%23ffffff&amp;ctz=Asia%2FHo_Chi_Minh&amp;src=cGhhbWN1b25ndGgyMDAwQGdtYWlsLmNvbQ&amp;src=Y2xhc3Nyb29tMTE0Mzk5MjQ3MTIwMjM5NTc0MTk4QGdyb3VwLmNhbGVuZGFyLmdvb2dsZS5jb20&amp;src=YWRkcmVzc2Jvb2sjY29udGFjdHNAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&amp;src=Y2xhc3Nyb29tMTA2NDAwMzExNDc2NDc2Njk0OTk1QGdyb3VwLmNhbGVuZGFyLmdvb2dsZS5jb20&amp;color=%23039BE5&amp;color=%230047a8&amp;color=%2333B679&amp;color=%23007b83"
							width="100%" height="600px" frameborder="0" scrolling="no"></iframe>
					</div>
					<div class="col-md-6">
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3619.614774027218!2d105.78734215530791!3d20.96544475848515!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ad29b81cac63%3A0xe5796c9507084b90!2zMTlhIFBo4buRIFhhIExhLCBQLiBQaMO6YyBMYSwgSMOgIMSQw7RuZywgSMOgIE7hu5lpIDEyMTA4!5e0!3m2!1svi!2s!4v1619148320132!5m2!1svi!2s"
							width="100%" height="600px" style="border: 0;" allowfullscreen=""
							loading="lazy"></iframe>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 slide-view">
						<div class="carousel slide">

							<div class="row">
								<div class="col-md-4">
									<img src="/img/1Fast-Furious-Presents-Hobbs-Shaw.jpg" alt="slide">
								</div>
								<div class="col-md-4">
									<img src="/img/2Avengers_Endgame.png" alt="slide">
								</div>
								<div class="col-md-4">
									<img src="/img/3Iron_Man3.jpg" alt="slide">
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
</body>

</html>

