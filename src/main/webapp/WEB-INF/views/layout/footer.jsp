<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- tich hop jstl vao jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!--  FOOTER -->
<div id="footer">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<a class="navbar-brand" href="/"><span class="display"
					style="color: white;">PHIMHAY</span> </a>
				<p style="color: white;">Trang chuyên chiếu phim với chất lượng
					tốt.</p>
				<ul class="social-icons">
					<li><i class="fab fa-facebook"></i></li>
					<li><i class="fab fa-skype"></i></li>
					<li><i class="fab fa-instagram"></i></li>
					<li><i class="fab fa-google-plus-square"></i></li>
				</ul>
			</div>
			<div class="col-md-2">
				<h3 class="font-weight-bold" style="color: aqua">PHIM MỚI</h3>
				<ul class="list-unstyled thongtin">
					<li><a href="http://localhost:6969/phim_le/?page=1">Phim
							lẻ mới</a></li>
					<li><a href="http://localhost:6969/phim_bo/?page=1">Phim
							bộ mới</a></li>
				</ul>
			</div>
			<div class="col-md-2">
				<h3 class="font-weight-bold" style="color: aqua">THỂ LOẠI</h3>
				<ul class="list-unstyled thongtin">
					<li><a href="/filter_movie/phim_hanh_dong/?page=1">Phim
							hành động</a></li>
					<li><a href="/filter_movie/phim_tinhcam_langman/?page=1">Phim
							lãng mạn</a></li>
					<li><a href="/filter_movie/phim_kinh_di/?page=1">Phim kinh
							dị</a></li>
					<li><a href="/filter_movie/phim_hai_huoc/?page=1">Phim hài
							hước</a></li>
				</ul>
			</div>
			<div class="col-md-2">
				<h3 class="font-weight-bold" style="color: aqua">NĂM</h3>
				<ul class="list-unstyled thongtin">
					<li><a href="/filter_movie/${filterTime }/?page=1">${filterTime }</a></li>
					<li><a href="/filter_movie/${filterTime1 }/?page=1">${filterTime1 }</a></li>
					<li><a href="/filter_movie/${filterTime2 }/?page=1">${filterTime2 }</a></li>
					<li><a href="/filter_movie/${filterTime3 }/?page=1">${filterTime3 }</a></li>
				</ul>
			</div>
			<div class="col-md-3">
				<h3 class="font-weight-bold" style="color: aqua">KẾT NỐI VỚI
					CHÚNG TÔI</h3>
				<div class="fb-page"
					data-href="https://www.facebook.com/Phim-Hay-102501102073621"
					data-tabs="timeline" data-width="300" data-height="230"
					data-small-header="false" data-adapt-container-width="true"
					data-hide-cover="false" data-show-facepile="true">
					<blockquote
						cite="https://www.facebook.com/Phim-Hay-102501102073621"
						class="fb-xfbml-parse-ignore">
						<a href="https://www.facebook.com/Phim-Hay-102501102073621">Phim
							Hay</a>
					</blockquote>
				</div>
			</div>
		</div>
		<hr>
		<div class="footer-copyright text-center py-3">
			©
			<c:set var="now" value="<%=new java.util.Date()%>" />
			<fmt:formatDate pattern="yyyy" value="${now}" />
			Copyright: <a href="https://www.facebook.com/cuongphamptit999/">
				CuongPham.com</a>
		</div>
	</div>
</div>
<div id="toTop">
	<img src="/img/arrow5-up-512.png" id="onTop" />
</div>

<!-- ------ -->