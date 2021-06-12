package vn.PTIT.controller.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.PTIT.beans.Search;
import vn.PTIT.beans.TimeUtils;
import vn.PTIT.entities.Role;
import vn.PTIT.entities.UserInfo;
import vn.PTIT.repositories.RoleRepository;
import vn.PTIT.repositories.UserInfoRepository;
import vn.PTIT.services.UserService;

@Controller
public class AdminUserController {
	@Autowired
	UserInfoRepository userInfoRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserService userService;
	
	private String passEdit;
	private String nameEdit;

	@RequestMapping(value = { "/admin/list-user" }, method = { RequestMethod.GET })
	public String listUser(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {

		// must have
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		Search search = new Search();
		model.addAttribute("search", search);

		model.addAttribute("user", userInfoRepository.findAll());
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));

		return "admin/list_user";
	}

	@RequestMapping(value = { "/admin/add-user" }, method = { RequestMethod.GET })
	public String regis(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		// must have
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userInfo", new UserInfo());
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));

		return "admin/register";
	}

	@RequestMapping(value = "/admin/add-user", method = RequestMethod.POST)
	public String register(@ModelAttribute("userInfo") UserInfo userInfo, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {

		// must have
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));

		Boolean flag = false;
		for (int i = 0; i < userInfoRepository.findAll().size(); i++) {
			if (userInfo.getUsername().compareTo(userInfoRepository.findAll().get(i).getUsername()) == 0) {
				flag = true;
				break;
			}
		}
		if (userInfo.getFullname().length() <= 0) {
			model.addAttribute("status", "faileNameNotNull");
		} else if (!userInfo.getEmail().matches("^[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com$")) {
			model.addAttribute("status", "faileEmailNotFormat");
		} else if (!userInfo.getMobile().matches("^0{1}[1-9]{1}\\d{8}$")) {
			model.addAttribute("status", "faileMobileNotFormat");
		} else if (userInfo.getUsername().length() <= 0) {
			model.addAttribute("status", "faileTenUserNotNull");
		} else if (flag) {
			model.addAttribute("status", "faileTenBiTrung");
		} else if (userInfo.getPassword().length() <= 0) {
			model.addAttribute("status", "failePassNotNull");
		} else {

			List<Role> roles = new ArrayList<Role>();
			Role role = roleRepository.getOne(2);
			roles.add(role);
			userInfo.setRoles(roles);
			userInfo.setStatus(true);
			String pass = userInfo.getPassword();
			userInfo.setPassword(passwordEncoder.encode(pass));

			userInfoRepository.save(userInfo);

			model.addAttribute("status", "success");
		}

		return "admin/register";
	}

	@RequestMapping(value = { "/admin/edit-user/{userId}" }, method = { RequestMethod.GET })
	public String editUser(@PathVariable int userId, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {

		// must have
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));
		model.addAttribute("userEdit", userInfoRepository.getOne(userId));
		passEdit=userInfoRepository.getOne(userId).getPassword();
		nameEdit=userInfoRepository.getOne(userId).getUsername();

		return "admin/edit_user";
	}

	@RequestMapping(value = "/admin/edit-user", method = RequestMethod.POST)
	public String edit_user(@ModelAttribute("userEdit") UserInfo userInfo, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {

		// must have
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		Search search = new Search();
		model.addAttribute("search", search);
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));

		if (userInfo.getFullname().isEmpty()) {
			model.addAttribute("status", "faileNameNotNull");
		} else if (!userInfo.getEmail().matches("^[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com$")) {
			model.addAttribute("status", "faileEmailNotFormat");
		} else if (!userInfo.getMobile().matches("^0{1}[1-9]{1}\\d{8}$")) {
			model.addAttribute("status", "faileMobileNotFormat");
		} else if (userInfo.getPassword().isEmpty()) {
			model.addAttribute("status", "failePassNotNull");
		} else {

			List<Role> roles = new ArrayList<Role>();
			Role role = roleRepository.getOne(2);
			roles.add(role);
			userInfo.setRoles(roles);
			userInfo.setStatus(true);
			String pass = userInfo.getPassword();
			if (!pass.equalsIgnoreCase(passEdit))
				userInfo.setPassword(passwordEncoder.encode(pass));
			userInfo.setUsername(nameEdit);
			userInfoRepository.save(userInfo);
			model.addAttribute("status", "success");
		}

		return "admin/edit_user";
	}

	@RequestMapping(value = { "/user/user-details" }, method = { RequestMethod.GET })
	public String userDetail(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {

		// must have
		model.addAttribute("imdb", TimeUtils.editTime());
		model.addAttribute("filterTime", TimeUtils.filterTime());
		model.addAttribute("filterTime1", TimeUtils.filterTime1());
		model.addAttribute("filterTime2", TimeUtils.filterTime2());
		model.addAttribute("filterTime3", TimeUtils.filterTime3());
		model.addAttribute("filterTime4", TimeUtils.filterTime4());

		Search search = new Search();
		model.addAttribute("search", search);
		
		model.addAttribute("userDis", userService.loadUserByUsername(request.getRemoteUser()));

		return "admin/user_details";
	}

}
