package vn.PTIT.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.PTIT.beans.Search;
import vn.PTIT.beans.TimeUtils;
import vn.PTIT.entities.Phim;
import vn.PTIT.repositories.PhimRepository;
import vn.PTIT.services.PhimService;

@Controller
public class LoaiPhimController {
	
	@Autowired PhimRepository phimRepository;
	@Autowired PhimService phimService;
	
	@RequestMapping(value = { "/phim_le" }, method = { RequestMethod.GET })
	public String phimle(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		int pageNumber = Integer.parseInt(request.getParameter("page"));
		
		model.addAttribute("phimle", phimService.search(2, pageNumber));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Search search = new Search();
		model.addAttribute("search", search);
		return "phim_le";
	}
	
	@RequestMapping(value = { "/phim_bo" }, method = { RequestMethod.GET })
	public String phimbo(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		int pageNumber = Integer.parseInt(request.getParameter("page"));
		
		model.addAttribute("phimbo", phimService.search(1, pageNumber));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Search search = new Search();
		model.addAttribute("search", search);
		return "phim_bo";
	}
	
	@RequestMapping(value = { "/odd_movie_details/{movieSeo}" }, method = { RequestMethod.GET })
	public String movie_details(@PathVariable String movieSeo, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		model.addAttribute("movie", phimService.searchMovieBySeo(movieSeo).get(0));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Search search = new Search();
		model.addAttribute("search", search);
		return "phimle_chi_tiet";
	}
	
	@RequestMapping(value = { "/series_movie_details/{movieSeo}" }, method = { RequestMethod.GET })
	public String seriesmovie_details(@PathVariable String movieSeo, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		model.addAttribute("movie", phimService.searchMovieBySeo(movieSeo).get(0));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Search search = new Search();
		model.addAttribute("search", search);
		return "phimbo_chi_tiet";
	}
	@RequestMapping(value = { "/movie_details/watch_odd_movie/{movieSeo}" }, method = { RequestMethod.GET })
	public String watch_movie(@PathVariable String movieSeo, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		model.addAttribute("see_movie", phimService.searchMovieBySeo(movieSeo).get(0));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Phim phim = phimService.searchMovieBySeo(movieSeo).get(0);
		int cnt=phim.getLuot_xem()+1;
		phim.setLuot_xem(cnt);
		
		phimRepository.save(phim);
		
		Search search = new Search();
		model.addAttribute("search", search);

		return "xem_phim_le";
	}
	@RequestMapping(value = { "/movie_details/watch_series_movie/{movieSeo}" }, method = { RequestMethod.GET })
	public String watch_seriesmovie(@PathVariable String movieSeo, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		model.addAttribute("see_movie", phimService.searchMovieBySeo(movieSeo).get(0));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Phim phim = phimService.searchMovieBySeo(movieSeo).get(0);
		int cnt=phim.getLuot_xem()+1;
		phim.setLuot_xem(cnt);
		
		phimRepository.save(phim);
		
		Search search = new Search();
		model.addAttribute("search", search);

		return "xem_phim_bo";
	}
	@RequestMapping(value = { "/movie_details/watch_odd_trailer/{movieSeo}" }, method = { RequestMethod.GET })
	public String watch_trailer(@PathVariable String movieSeo, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		model.addAttribute("see_trailer", phimService.searchMovieBySeo(movieSeo).get(0));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Search search = new Search();
		model.addAttribute("search", search);

		return "xem_odd_trailer";
	}
	@RequestMapping(value = { "/movie_details/watch_series_trailer/{movieSeo}" }, method = { RequestMethod.GET })
	public String watch_seriestrailer(@PathVariable String movieSeo, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		model.addAttribute("see_trailer", phimService.searchMovieBySeo(movieSeo).get(0));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Search search = new Search();
		model.addAttribute("search", search);

		return "xem_series_trailer";
	}
	@RequestMapping(value = { "/movie_details/download_series_movie/{movieSeo}" }, method = { RequestMethod.GET })
	public String download_seriesmovie(@PathVariable String movieSeo, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		model.addAttribute("see_movie", phimService.searchMovieBySeo(movieSeo).get(0));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Search search = new Search();
		model.addAttribute("search", search);

		return "download_series_movie";
	}
	@RequestMapping(value = { "/movie_details/download_odd_movie/{movieSeo}" }, method = { RequestMethod.GET })
	public String download_oddmovie(@PathVariable String movieSeo, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		model.addAttribute("see_movie", phimService.searchMovieBySeo(movieSeo).get(0));
		
		model.addAttribute("phimlehot", phimService.hotOddMovie());
		model.addAttribute("phimserieshot", phimService.hotSeriesMovie());
		
		Search search = new Search();
		model.addAttribute("search", search);

		return "download_odd_movie";
	}
}
