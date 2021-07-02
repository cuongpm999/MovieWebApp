<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- tich hop jstl vao jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- HEADER -->
<div id="header">
	<div class="head-movie">
		<div class="container head">
			<div class="row">
				<div class="col-md-4">
					<a class="navbar-brand" href="/"> <img src="/img/logo.png"
						alt="logo">
					</a>
				</div>
				<div class="col-md-8">
					<div class="widget_search">
						<form:form modelAttribute="search" action="/movies/searchName">
							<div>
								<form:input type="search" path="name" placeholder="Tìm tên..." />
								<button type="submit" class="btn btn-success">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>


		</div>
	</div>
	<div class="head-nav">
		<nav class="container navbar navbar-expand-lg bg-dark navbar-dark">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse navbar_right"
				id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/">TRANG
							CHỦ</a></li>
					<li class="nav-item dropdown"><a class="nav-link"> THỂ
							LOẠI </a>
						<div class="dropdown-menu multi-column columns-4">
							<div class="row">
								<div class="col-md-3">
									<ul class="list-unstyled multi-column-dropdown">
										<li><a href="/filter_movie/phim_hanh_dong/?page=1">Phim hành động</a></li>
										<li><a href="/filter_movie/phim_hai_huoc/?page=1">Phim hài hước</a></li>
										<li><a href="/filter_movie/phim_co_trang/?page=1">Phim cổ trang</a></li>
										<li><a href="/filter_movie/phim_chinh_kich/?page=1">Phim chính kịch</a></li>
										<li><a href="/filter_movie/phim_phieu_luu/?page=1">Phim phiêu lưu</a></li>
									</ul>
								</div>
								<div class="col-md-3">
									<ul class="list-unstyled multi-column-dropdown">
										<li><a href="/filter_movie/phim_vien_tuong/?page=1">Phim viễn tưởng</a></li>
										<li><a href="/filter_movie/phim_thethao_amnhac/?page=1">Phim thể thao - âm nhạc</a></li>
										<li><a href="/filter_movie/phim_than_thoai/?page=1">Phim thần thoại</a></li>
										<li><a href="/filter_movie/phim_vo_thuat/?page=1">Phim võ thuật</a></li>
										<li><a href="/filter_movie/phim_tinhcam_langman/?page=1">Phim tình cảm - lãng mạn</a></li>
									</ul>
								</div>
								<div class="col-md-3">
									<ul class="list-unstyled multi-column-dropdown">
										<li><a href="/filter_movie/phim_chien_tranh/?page=1">Phim chiến tranh</a></li>
										<li><a href="/filter_movie/phim_kinh_di/?page=1">Phim kinh dị</a></li>
										<li><a href="/filter_movie/phim_tam_ly/?page=1">Phim tâm lý</a></li>
										<li><a href="/filter_movie/phim_gia_dinh/?page=1">Phim gia đình</a></li>
										<li><a href="/filter_movie/phim_bian_sieunhien/?page=1">Phim bí ẩn - siêu nhiên</a></li>
									</ul>
								</div>
								<div class="col-md-3">
									<ul class="list-unstyled multi-column-dropdown">
										<li><a href="/filter_movie/phim_hinh_su/?page=1">Phim hình sự</a></li>
										<li><a href="/filter_movie/phim_hoihop_gaycan/?page=1">Phim hồi hộp - gay cấn</a></li>
										<li><a href="/filter_movie/phim_tai_lieu/?page=1">Phim tài liệu</a></li>
										<li><a href="/filter_movie/phim_hoat_hinh/?page=1">Phim hoạt hình</a></li>
									</ul>
								</div>
							</div>
						</div></li>
					<li class="nav-item dropdown"><a class="nav-link">NĂM</a>
						<div class="dropdown-menu multi-column columns-3">
							<div class="row">
								<div class="col-md-4">
									<ul class="list-unstyled multi-column-dropdown">
										<li><a href="/filter_movie/${filterTime }/?page=1">${filterTime }</a></li>
										<li><a href="/filter_movie/${filterTime1 }/?page=1">${filterTime1 }</a></li>
									</ul>
								</div>
								<div class="col-md-4">
									<ul class="list-unstyled multi-column-dropdown">
										<li><a href="/filter_movie/${filterTime2 }/?page=1">${filterTime2 }</a></li>
										<li><a href="/filter_movie/${filterTime3 }/?page=1">${filterTime3 }</a></li>
									</ul>
								</div>
								<div class="col-md-4">
									<ul class="list-unstyled multi-column-dropdown">
										<li><a href="/filter_movie/${filterTime4 }/?page=1">${filterTime4 }</a></li>
										<li><a href="/filter_movie/truoc_${filterTime4 }/?page=1">Trước ${filterTime4 }</a></li>
									</ul>
								</div>
							</div>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="/phim_le/?page=1">
							PHIM LẺ </a></li>
					<li class="nav-item"><a class="nav-link" href="/phim_bo/?page=1">
							PHIM BỘ </a></li>
					<li class="nav-item"><a class="nav-link" href="/imdb">TOP
							IMDB ${imdb}</a></li>
					<li class="nav-item icon"><a class="nav-link"
						href="/user/manage"><i class="fas fa-user"></i></a></li>
				</ul>
			</div>
		</nav>

	</div>

</div>
<!-- ---- -->
