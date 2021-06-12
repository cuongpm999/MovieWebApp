package vn.PTIT.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.PTIT.beans.Search;
import vn.PTIT.beans.TimeUtils;
import vn.PTIT.beans.Utilities;
import vn.PTIT.entities.Phim;
import vn.PTIT.entities.PosterVideoPhim;
import vn.PTIT.repositories.HinhThucRepository;
import vn.PTIT.repositories.PhimRepository;
import vn.PTIT.services.UserService;

@Controller
public class AdminMovieController {
	@Autowired HinhThucRepository hinhThucRepository;
	@Autowired PhimRepository phimRepository;
	@Autowired
	UserService userService;
	
	private String seoEdit;
	private int viewEdit;
	
	@RequestMapping(value = { "/user/add-movie" }, method = { RequestMethod.GET })
	public String add_carsproduct(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("phim", new Phim());
		model.addAttribute("hinhThucRepositories", hinhThucRepository.findAll());
		
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));
		
		return "admin/add_movie";
	}
	
	@RequestMapping(value = "/user/add-movie", method = RequestMethod.POST)
	public String add_movie(@RequestParam("idPosterVideo") String idPosterVideo,
			@ModelAttribute("phim") Phim phim, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response)
			throws IllegalStateException, IOException {
		if(!idPosterVideo.isEmpty()) {
			String datas[] = idPosterVideo.split("/");
			for (String data : datas) {
				PosterVideoPhim posterVideoPhim = new PosterVideoPhim();
				posterVideoPhim.setId_google_drive(data.trim());
				posterVideoPhim.setStatus(true);
				phim.addPosterPhim(posterVideoPhim);
			}
			
		}
		phim.setLuot_xem(0);
		phim.setStatus(true);
		Utilities utilities = new Utilities();
		phim.setSeo(utilities.createSeoLink(phim.getTen_phim_tienganh()));
		phimRepository.save(phim);
		model.addAttribute("hinhThucRepositories",hinhThucRepository.findAll());
		model.addAttribute("status", "success");
		
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));
		
		return "admin/add_movie";
	}
	
	@RequestMapping(value = { "/user/list-movie" }, method = { RequestMethod.GET })
	public String list_movie(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		List<Phim> phims = phimRepository.findAll();
		model.addAttribute("movies", phims);
		
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));
		
		return "admin/list_movie";
	}
	
	@RequestMapping(value = { "/user/edit-movie/{movieId}" }, method = { RequestMethod.GET })
	public String editMovie(@PathVariable int movieId, final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("hinhThucRepositories", hinhThucRepository.findAll());
		Phim phim = phimRepository.getOne(movieId);
		model.addAttribute("phim", phim);
		
		seoEdit = phim.getSeo();
		viewEdit = phim.getLuot_xem();
		
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
	
		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));
		
		return "admin/edit_movie";
	}
	
	@RequestMapping(value = { "/user/edit-movie" }, method = { RequestMethod.POST })
	public String saveMovie(@RequestParam("idPosterVideo") String idPosterVideo, @ModelAttribute("phim") Phim phim, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("hinhThucRepositories", hinhThucRepository.findAll());
		
		phim.setSeo(seoEdit);
		phim.setLuot_xem(viewEdit);
		phim.setStatus(true);
		
		if(!idPosterVideo.isEmpty()) {
			String datas[] = idPosterVideo.split("/");
			for (String data : datas) {
				PosterVideoPhim posterVideoPhim = new PosterVideoPhim();
				posterVideoPhim.setId_google_drive(data.trim());
				posterVideoPhim.setStatus(true);
				phim.addPosterPhim(posterVideoPhim);
			}
			
		}
		
		phimRepository.save(phim);
		model.addAttribute("status", "success");
		
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());
		
		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));
		
		return "admin/edit_movie";

	}
	
	
}
