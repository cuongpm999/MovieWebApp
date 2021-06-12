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
	href="${pageContext.request.contextPath}/css/phim_chi_tiet.css">
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
			<div class="chi-tiet">
				<div class="row">
					<div class="col-md-6 poster">
						<img
							src="https://drive.google.com/uc?export=view&id=${movie.posterVideoPhims.get(0).id_google_drive }"
							alt="movie">
						<ul class="btn-block list-unstyled">
							<li class="item"><a id="btn-film-download"
								class="btn btn-success btn"
								href="/movie_details/download_odd_movie/${movie.seo }">Download</a></li>
							<li class="item"><a id="btn-film-trailer"
								class="btn btn-primary btn-film-trailer"
								href="/movie_details/watch_odd_trailer/${movie.seo }">Trailer</a></li>
							<li class="item"><a id="btn-film-watch"
								class="btn btn-danger"
								href="/movie_details/watch_odd_movie/${movie.seo }">Xem phim</a></li>
						</ul>
					</div>
					<div class="col-md-6 infor-movie">
						<h2>XEM PHIM ${movie.ten_phim_tiengviet }</h2>
						<p class="en">${movie.ten_phim_tienganh }</p>
						<dl class="movie-dl scrollbar" id="style-1">
							<dt class="movie-dt">Trạng thái:</dt>
							<dd class="movie-dd status" style="color: red;">Hoàn tất</dd>
							<br>
							<dt class="movie-dt">Điểm IMDb:</dt>
							<dd class="movie-dd imdb">${movie.diem_IMDb }</dd>
							<br>
							<dt class="movie-dt">Đạo diễn:</dt>
							<dd class="movie-dd dd-director">${movie.dao_dien }</dd>
							<br>
							<dt class="movie-dt">Quốc gia:</dt>
							<dd class="movie-dd dd-country">${movie.quoc_gia }</dd>
							<br>
							<dt class="movie-dt">Năm:</dt>
							<dd class="movie-dd">${movie.nam }</dd>
							<br>
							<dt class="movie-dt">Thời lượng:</dt>
							<dd class="movie-dd">${movie.thoi_luong }</dd>
							<br>
							<dt class="movie-dt">Chất lượng:</dt>
							<dd class="movie-dd">${movie.chat_luong }</dd>
							<br>
							<dt class="movie-dt">Ngôn ngữ:</dt>
							<dd class="movie-dd">Vietsub</dd>
							<br>
							<dt class="movie-dt">Thể loại:</dt>
							<dd class="movie-dd dd-cat">${movie.the_loai }</dd>
							<br>
							<dt class="movie-dt">Công ty SX:</dt>
							<dd class="movie-dd">${movie.congty_sx }</dd>
						</dl>
					</div>
				</div>
				<div class="noidung">
					<h4 class="detail-movie">NỘI DUNG PHIM</h4>
					<h1 class="my-3"></h1>
					<p class="content-movie">
						${movie.noi_dung_phim }</p>
				</div>
				<h4 class="trailer">TRAILER</h4>
				<iframe width="100%" height="400" src="${movie.trailer }"
					frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
			<div class="binhluan">
				<h4>BÌNH LUẬN</h4>
				<div style="background-color: rgba(65, 63, 63, 0.678);">
					<div class="fb-comments"
						data-href="https://developers.facebook.com/docs/plugins/comments#configurator/${movie.seo }"
						data-width="100%" data-numposts="5"></div>
				</div>
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