package vn.PTIT.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.PTIT.entities.AjaxResponse;
import vn.PTIT.entities.Phim;
import vn.PTIT.repositories.PhimRepository;
import vn.PTIT.repositories.UserInfoRepository;
import vn.PTIT.services.PhimService;


@RestController
@RequestMapping("/rest/api")
public class AjaxController {
	
	@Autowired PhimRepository phimRepository;
	@Autowired UserInfoRepository userInfoRepository;
	@Autowired PhimService phimService;

	@PostMapping(value = "/movie/delete")
	public ResponseEntity<AjaxResponse> movieDelete(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		Integer entityId = (Integer) data.get("entityId");
		phimRepository.deleteById(entityId);
		return ResponseEntity.ok(new AjaxResponse(69,data));
	}
	
	@PostMapping(value = "/user/delete")
	public ResponseEntity<AjaxResponse> userDelete(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		Integer entityId = (Integer) data.get("entityId");
		userInfoRepository.deleteById(entityId);
		return ResponseEntity.ok(new AjaxResponse(69,data));
	}

}
