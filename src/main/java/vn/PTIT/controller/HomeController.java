package vn.PTIT.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.PTIT.beans.Search;
import vn.PTIT.beans.TimeUtils;
import vn.PTIT.entities.Phim;
import vn.PTIT.repositories.PhimRepository;
import vn.PTIT.services.PhimService;
import vn.PTIT.services.UserService;

@Controller
public class HomeController {

	@Autowired
	PhimRepository phimRepository;
	@Autowired
	PhimService phimService;
	@Autowired
	UserService userService;

	@RequestMapping(value = { "/", "/index", "/home" }, method = { RequestMethod.GET })
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimle", phimService.search1(2));
		model.addAttribute("phimbo", phimService.search1(1));

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("cartoon", phimService.cartoonMovie());

		Search search = new Search();
		model.addAttribute("search", search);

		return "index";
	}

	@RequestMapping(value = { "/user/manage" }, method = { RequestMethod.GET })
	public String quanly(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));
		
		List<Phim> phim = phimRepository.findAll();
		Collections.sort(phim, new Comparator<Phim>() {

			@Override
			public int compare(Phim o1, Phim o2) {
				return o2.getLuot_xem()-o1.getLuot_xem();
			}
		});
		model.addAttribute("listMovieRP", phim);
		// trả về tên view.
		return "admin/manage";

	}

	@RequestMapping(value = { "/login" }, method = { RequestMethod.GET })
	public String login(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		Search search = new Search();
		model.addAttribute("search", search);
		// trả về tên view.
		return "login";

	}

	@RequestMapping(value = { "/imdb" }, method = { RequestMethod.GET })
	public String imdb(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		// trả về tên view.
		return "imdb";

	}

	@RequestMapping(value = { "/movies/searchName" }, method = { RequestMethod.POST })
	public String search1(@ModelAttribute("search") Search search, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		String nameMovie = search.getName();
		model.addAttribute("movie", phimService.searchName(nameMovie));
		return "tim_phim";
	}

	@RequestMapping(value = { "/filter_movie/phim_hoat_hinh" }, method = { RequestMethod.GET })
	public String locphim1(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);

		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim hoạt hình", pageNumber));
		model.addAttribute("theloai", "Phim hoạt hình");
		// trả về tên view.
		return "loc_phim_theloai";
	}

	@RequestMapping(value = { "/filter_movie/phim_hanh_dong" }, method = { RequestMethod.GET })
	public String locphim2(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim hành động", pageNumber));
		model.addAttribute("theloai", "Phim hành động");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_hai_huoc" }, method = { RequestMethod.GET })
	public String locphim3(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim hài hước", pageNumber));
		model.addAttribute("theloai", "Phim hài hước");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_co_trang" }, method = { RequestMethod.GET })
	public String locphim5(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		Search search = new Search();
		model.addAttribute("search", search);

		model.addAttribute("movie", phimService.searchTheLoai("Phim cổ trang", pageNumber));
		model.addAttribute("theloai", "Phim cổ trang");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_tai_lieu" }, method = { RequestMethod.GET })
	public String locphim6(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim tài liệu", pageNumber));
		model.addAttribute("theloai", "Phim tài liệu");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_hoihop_gaycan" }, method = { RequestMethod.GET })
	public String locphim7(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		Search search = new Search();
		model.addAttribute("search", search);

		model.addAttribute("movie", phimService.searchTheLoai("Phim hồi hộp - gay cấn", pageNumber));
		model.addAttribute("theloai", "Phim hồi hộp - gay cấn");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_hinh_su" }, method = { RequestMethod.GET })
	public String locphim8(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim hình sự", pageNumber));
		model.addAttribute("theloai", "Phim hình sự");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_bian_sieunhien" }, method = { RequestMethod.GET })
	public String locphim9(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim bí ẩn - siêu nhiên", pageNumber));
		model.addAttribute("theloai", "Phim bí ẩn - siêu nhiên");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_gia_dinh" }, method = { RequestMethod.GET })
	public String locphim10(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim gia đình", pageNumber));
		model.addAttribute("theloai", "Phim gia đình");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_tam_ly" }, method = { RequestMethod.GET })
	public String locphim11(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim tâm lý", pageNumber));
		model.addAttribute("theloai", "Phim tâm lý");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_kinh_di" }, method = { RequestMethod.GET })
	public String locphim12(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim kinh dị", pageNumber));
		model.addAttribute("theloai", "Phim kinh dị");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_chien_tranh" }, method = { RequestMethod.GET })
	public String locphim13(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim chiến tranh", pageNumber));
		model.addAttribute("theloai", "Phim chiến tranh");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_tinhcam_langman" }, method = { RequestMethod.GET })
	public String locphim14(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim tình cảm - lãng mạn", pageNumber));
		model.addAttribute("theloai", "Phim tình cảm - lãng mạn");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_vo_thuat" }, method = { RequestMethod.GET })
	public String locphim15(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim võ thuật", pageNumber));
		model.addAttribute("theloai", "Phim võ thuật");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_than_thoai" }, method = { RequestMethod.GET })
	public String locphim16(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim thần thoại", pageNumber));
		model.addAttribute("theloai", "Phim thần thoại");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_thethao_amnhac" }, method = { RequestMethod.GET })
	public String locphim17(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim thể thao - âm nhạc", pageNumber));
		model.addAttribute("theloai", "Phim thể thao - âm nhạc");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_vien_tuong" }, method = { RequestMethod.GET })
	public String locphim18(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim viễn tưởng", pageNumber));
		model.addAttribute("theloai", "Phim viễn tưởng");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_phieu_luu" }, method = { RequestMethod.GET })
	public String locphim19(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim phiêu lưu", pageNumber));
		model.addAttribute("theloai", "Phim phiêu lưu");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/phim_chinh_kich" }, method = { RequestMethod.GET })
	public String locphim20(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		int pageNumber = Integer.parseInt(request.getParameter("page"));

		model.addAttribute("movie", phimService.searchTheLoai("Phim chính kịch", pageNumber));
		model.addAttribute("theloai", "Phim chính kịch");
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/{nam}" }, method = { RequestMethod.GET })
	public String locphim_theonam1(@PathVariable int nam, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		
		int pageNumber = Integer.parseInt(request.getParameter("page"));
		model.addAttribute("movie", phimService.searchNam(nam, pageNumber));

		if (nam == TimeUtils.filterTime()) {
			model.addAttribute("theloai", "Năm " + TimeUtils.filterTime());
			model.addAttribute("namdep", TimeUtils.filterTime());
		}
		else if (nam == TimeUtils.filterTime1()) {
			model.addAttribute("theloai", "Năm " + TimeUtils.filterTime1());
			model.addAttribute("namdep", TimeUtils.filterTime1());
		} else if (nam == TimeUtils.filterTime2()) {
			model.addAttribute("theloai", "Năm " + TimeUtils.filterTime2());
			model.addAttribute("namdep", TimeUtils.filterTime2());
		}
		else if (nam == TimeUtils.filterTime3()) {
			model.addAttribute("theloai", "Năm " + TimeUtils.filterTime3());
			model.addAttribute("namdep", TimeUtils.filterTime3());
		}
		else if (nam == TimeUtils.filterTime4()) {
			model.addAttribute("theloai", "Năm " + TimeUtils.filterTime4());
			model.addAttribute("namdep", TimeUtils.filterTime4());
		}
		// trả về tên view.
		return "loc_phim_theloai";

	}

	@RequestMapping(value = { "/filter_movie/truoc_{nam}" }, method = { RequestMethod.GET })
	public String locphim_theonam2(@PathVariable int nam, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());

		model.addAttribute("imdbMovie", phimService.imdbMovie(2));

		Search search = new Search();
		model.addAttribute("search", search);
		
		int pageNumber = Integer.parseInt(request.getParameter("page"));
		model.addAttribute("movie", phimService.searchTruocNam(nam, pageNumber));

		model.addAttribute("theloai", "Trước năm " + TimeUtils.filterTime4());
		model.addAttribute("truocnam", "Trước năm " + + TimeUtils.filterTime4());
		// trả về tên view.
		return "loc_phim_theloai";

	}
	
	@RequestMapping(value = { "/error-403" }, method = { RequestMethod.GET })
	public String error403(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {

		// must have
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		Search search = new Search();
		model.addAttribute("search", search);

		return "error_403";
	}

}
