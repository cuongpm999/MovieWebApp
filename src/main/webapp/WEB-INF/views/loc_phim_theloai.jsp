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
	href="${pageContext.request.contextPath}/css/loai_phim.css">
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
			<h2 class="tieude text-uppercase">${theloai }</h2>
			<div class="row">
				<c:forEach var="movie" items="${movie }">
					<c:choose>
						<c:when test="${movie.hinhThuc.id=='1' }">
							<div class="col-md-4">
								<a href="/series_movie_details/${movie.seo }"><img
									src="https://drive.google.com/uc?export=view&id=${movie.posterVideoPhims.get(0).id_google_drive }"
									alt="movie">
									<div class="movie-action-icon">
										<i class="far fa-play-circle"></i>
									</div> </a>
								<div class="ten_phim">
									<a href="/series_movie_details/${movie.seo }">
										<h6 class="font-weight-bold">${movie.ten_phim_tiengviet }</h6>
									</a> <a class="english" href="/series_movie_details/${movie.seo }">
										${movie.ten_phim_tienganh } </a> <span class="time">${movie.thoi_luong }</span>
								</div>
								<span class="ribbon">${movie.chat_luong }-Vietsub |
									${movie.so_tap }</span>
							</div>
						</c:when>
						<c:when test="${movie.hinhThuc.id=='2' }">
							<div class="col-md-4">
								<a href="/odd_movie_details/${movie.seo }"><img
									src="https://drive.google.com/uc?export=view&id=${movie.posterVideoPhims.get(0).id_google_drive }"
									alt="movie">
									<div class="movie-action-icon">
										<i class="far fa-play-circle"></i>
									</div> </a>
								<div class="ten_phim">
									<a href="/odd_movie_details/${movie.seo }">
										<h6 class="font-weight-bold">${movie.ten_phim_tiengviet }</h6>
									</a> <a class="english" href="/odd_movie_details/${movie.seo }">
										${movie.ten_phim_tienganh } </a> <span class="time">${movie.thoi_luong }</span>
								</div>
								<span class="ribbon">${movie.chat_luong }-Vietsub</span>
							</div>
						</c:when>
					</c:choose>
				</c:forEach>
			</div>
			<c:choose>
				<c:when test="${theloai=='Phim hành động' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_hanh_dong/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_hanh_dong/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim hoạt hình' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_hoat_hinh/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_hoat_hinh/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim hài hước' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_hai_huoc/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_hai_huoc/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim cổ trang' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_co_trang/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_co_trang/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim chính kịch' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_chinh_kich/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_chinh_kich/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim phiêu lưu' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_phieu_luu/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_phieu_luu/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim viễn tưởng' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_vien_tuong/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_vien_tuong/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim thể thao - âm nhạc' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_thethao_amnhac/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_thethao_amnhac/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim thần thoại' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_than_thoai/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_than_thoai/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim võ thuật' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_vo_thuat/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_vo_thuat/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim tình cảm - lãng mạn' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('filter_movie/phim_tinhcam_langman/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_tinhcam_langman/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim chiến tranh' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_chien_tranh/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_chien_tranh/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim kinh dị' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_kinh_di/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_kinh_di/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim tâm lý' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_tam_ly/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_tam_ly/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim gia đình' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_gia_dinh/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_gia_dinh/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim bí ẩn - siêu nhiên' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_bian_sieunhien/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_bian_sieunhien/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim hình sự' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_hinh_su/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_hinh_su/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim hồi hộp - gay cấn' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_hoihop_gaycan/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_hoihop_gaycan/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim tài liệu' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_tai_lieu/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_tai_lieu/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${theloai=='Phim hoạt hình' }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/phim_hoat_hinh/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/phim_hoat_hinh/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${filterTime1==namdep }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/${filterTime1 }/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/${filterTime1 }/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${filterTime2==namdep }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/${filterTime2 }/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/${filterTime2 }/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${filterTime3==namdep }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/${filterTime3 }/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/${filterTime3 }/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${filterTime4==namdep }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/${filterTime4 }/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/${filterTime4 }/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				<c:when test="${filterTime==namdep }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/${filterTime }/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/${filterTime }/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when>
				
				 <c:when test="${theloai==truocnam }">
					<div class="page-link">
						<a href="javascript:Blog.goPrev('/filter_movie/truoc_${filterTime4 }/')"><i
							class="fas fa-chevron-left"></i></a> <a
							href="javascript:Blog.goNext('/filter_movie/truoc_${filterTime4 }/')"><i
							class="fas fa-chevron-right"></i></a>
					</div>
				</c:when> 
				
			</c:choose>

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