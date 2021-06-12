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
<!-- ----------------- -->

<title>Movie Project</title>
</head>

<body>
	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v5.0"></script>

	<!-- HEADER -->
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main" class="container">
		<h1 class="my-5"></h1>
		<div class="col-md-9 phim">
			<a href="/phim_le/?page=1" class="xemtatca">Xem tất cả</a>
			<h2 class="tieude">PHIM LẺ MỚI CẬP NHẬT</h2>
			<div class="row">
				<c:forEach var="phimle" items="${phimle }" varStatus="loop">
					<c:if test="${loop.index <12 }">
						<div class="col-md-3">
							<a href="/odd_movie_details/${phimle.seo }"><img
								src="https://drive.google.com/uc?export=view&id=${phimle.posterVideoPhims.get(0).id_google_drive }"
								alt="movie">
								<div class="movie-action-icon">
									<i class="far fa-play-circle"></i>
								</div> </a>
							<div class="ten_phim">
								<a href="/odd_movie_details/${phimle.seo }">
									<h6 class="font-weight-bold">${phimle.ten_phim_tiengviet }</h6>
								</a> <a class="english" href="/odd_movie_details/${phimle.seo }">${phimle.ten_phim_tienganh }</a>
								<span class="time">${phimle.thoi_luong }</span>
							</div>
							<span class="ribbon">${phimle.chat_luong }-Vietsub</span>
						</div>
					</c:if>
				</c:forEach>

			</div>

			<h1 class="my-5"></h1>
			<a href="/phim_bo/?page=1" class="xemtatca">Xem tất cả</a>
			<h2 class="tieude">PHIM BỘ MỚI CẬP NHẬT</h2>
			<div class="row">
				<c:forEach var="phimbo" items="${phimbo }" varStatus="loop">
					<c:if test="${loop.index <12 }">
						<div class="col-md-3">
							<a href="/series_movie_details/${phimbo.seo }"><img
								src="https://drive.google.com/uc?export=view&id=${phimbo.posterVideoPhims.get(0).id_google_drive }"
								alt="movie">
								<div class="movie-action-icon">
									<i class="far fa-play-circle"></i>
								</div> </a>
							<div class="ten_phim">
								<a href="/series_movie_details/${phimbo.seo }">
									<h6 class="font-weight-bold">${phimbo.ten_phim_tiengviet }</h6>
								</a> <a class="english" href="/series_movie_details/${phimbo.seo }">${phimbo.ten_phim_tienganh }</a>
								<span class="time">${phimbo.thoi_luong }</span>
							</div>
							<span class="ribbon">${phimbo.chat_luong }-Vietsub |
								${phimbo.so_tap }</span>
						</div>
					</c:if>
				</c:forEach>
			</div>

			<h1 class="my-5"></h1>
			<a href="/filter_movie/phim_hoat_hinh/?page=1" class="xemtatca">Xem
				tất cả</a>
			<h2 class="tieude">PHIM HOẠT HÌNH MỚI CẬP NHẬT</h2>
			<div class="row">
				<c:forEach var="cartoon" items="${cartoon}" varStatus="loop">
					<c:if test="${loop.index <12 }">
						<c:choose>
							<c:when test="${cartoon.hinhThuc.id=='1' }">
								<div class="col-md-3">
									<a href="/series_movie_details/${cartoon.seo }"><img
										src="https://drive.google.com/uc?export=view&id=${cartoon.posterVideoPhims.get(0).id_google_drive }"
										alt="movie">
										<div class="movie-action-icon">
											<i class="far fa-play-circle"></i>
										</div> </a>
									<div class="ten_phim">
										<a href="/series_movie_details/${cartoon.seo }">
											<h6 class="font-weight-bold">${cartoon.ten_phim_tiengviet }</h6>
										</a> <a class="english"
											href="/series_movie_details/${cartoon.seo }">
											${cartoon.ten_phim_tienganh } </a> <span class="time">${cartoon.thoi_luong }</span>
									</div>
									<span class="ribbon">${cartoon.chat_luong }-Vietsub |
										${cartoon.so_tap }</span>
								</div>
							</c:when>
							<c:when test="${cartoon.hinhThuc.id=='2' }">
								<div class="col-md-3">
									<a href="/odd_movie_details/${cartoon.seo }"><img
										src="https://drive.google.com/uc?export=view&id=${cartoon.posterVideoPhims.get(0).id_google_drive }"
										alt="movie">
										<div class="movie-action-icon">
											<i class="far fa-play-circle"></i>
										</div> </a>
									<div class="ten_phim">
										<a href="/odd_movie_details/${cartoon.seo }">
											<h6 class="font-weight-bold">${cartoon.ten_phim_tiengviet }</h6>
										</a> <a class="english" href="/odd_movie_details/${cartoon.seo }">
											${cartoon.ten_phim_tienganh } </a> <span class="time">${cartoon.thoi_luong }</span>
									</div>
									<span class="ribbon">${cartoon.chat_luong }-Vietsub</span>
								</div>
							</c:when>
						</c:choose>
					</c:if>
				</c:forEach>
			</div>

		</div>

		<div class="col-md-3 danhmuc">
			<h1 class="my-2"></h1>
			<h5 class="tieude font-weight-bold">PHIM LẺ HOT TRONG TUẦN</h5>
			<ul class="list-unstyled list-phim scrollbar" id="style-1">
				<c:forEach var="phimlehot" items="${phimlehot }" varStatus="loop">
					<c:if test="${loop.index <9 }">
						<li>
							<div class="row">
								<div class="col-md-4">
									<a href="/odd_movie_details/${phimlehot.seo }"><img
										src="https://drive.google.com/uc?export=view&id=${phimlehot.posterVideoPhims.get(0).id_google_drive }"
										alt="movie"></a>
								</div>
								<div class="col-md-8 list-phim-infor">
									<a href="/odd_movie_details/${phimlehot.seo }"> <span
										class="list-phim-infor-vn">${phimlehot.ten_phim_tiengviet }</span>
										<br> <span class="list-phim-infor-en">${phimlehot.ten_phim_tienganh }</span>
									</a> <br> <span class="list-phim-infor-view">Lượt xem:
										${phimlehot.luot_xem }</span>
								</div>

							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>

			<h1 class="my-5"></h1>
			<h5 class="tieude font-weight-bold">PHIM BỘ HOT TRONG TUẦN</h5>
			<ul class="list-unstyled list-phim scrollbar" id="style-1">
				<c:forEach var="phimserieshot" items="${phimserieshot }"
					varStatus="loop">
					<c:if test="${loop.index <9 }">
						<li>
							<div class="row">
								<div class="col-md-4">
									<a href="/series_movie_details/${phimserieshot.seo }"><img
										src="https://drive.google.com/uc?export=view&id=${phimserieshot.posterVideoPhims.get(0).id_google_drive }"
										alt="movie"></a>
								</div>
								<div class="col-md-8 list-phim-infor">
									<a href="/series_movie_details/${phimserieshot.seo }"> <span
										class="list-phim-infor-vn">${phimserieshot.ten_phim_tiengviet }</span>
										<br> <span class="list-phim-infor-en">${phimserieshot.ten_phim_tienganh }</span>
									</a> <br> <span class="list-phim-infor-view">Lượt xem:
										${phimserieshot.luot_xem }</span>
								</div>

							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>

		</div>

		<div class="clear-with-height"></div>
		<h1 class=my-5></h1>
	</div>

	<!--  FOOTER -->
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	<!-- ------- -->
</body>

</html>