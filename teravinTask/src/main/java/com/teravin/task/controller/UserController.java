package com.teravin.task.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teravin.task.model.UserModel;
import com.teravin.task.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/sidenav")
	public String sidenav() {
		return "/components/sidenav";
	}
	
	@RequestMapping("user/sidenav")
	public String p_sidenav() {
		return "/components/sidenav";
	}

	@RequestMapping("/")
	public String index() {
		return "/index";
	}

	@RequestMapping("user/topnav")
	public String p_topnav() {
		return "/components/topnav";
	}

	@RequestMapping("user/fe_list")
	public String fe_list_user(Model model, @PageableDefault(page = 0, value = 10) Pageable pageable) {
		
		Page<UserModel> userModelList = userService.listUser(pageable);
		model.addAttribute("userModelList", userModelList);
		
		return "user/fe_list";
	}
	
	@RequestMapping("user/modal_tambah")
	public String modal_tambah() {
		return "user/modal-tambah";
	}
	
	@RequestMapping("/user/list")
	public String list_user(Model model) {

		List<UserModel> userModelList = new ArrayList<UserModel>();
		userModelList = userService.listUser();
		model.addAttribute("userModelList", userModelList);

		return "/user/list";
	}

	@RequestMapping("/user/form_tambah")
	public String form_tambah() {
		return "/user/form_tambah";
	}

	@RequestMapping("/user/tambah_data")
	public String tambah_user(HttpServletRequest request, Model model) {

		String nama_user = request.getParameter("nama_user");
		String no_hp = request.getParameter("no_hp");
		String email = request.getParameter("email");
		String alamat1 = request.getParameter("alamat1");
		String alamat2 = request.getParameter("alamat2");
		String alamat3 = request.getParameter("alamat3");

		UserModel userModel = new UserModel();

		userModel.setNama_user(nama_user);
		userModel.setNo_hp(no_hp);
		userModel.setEmail(email);
		userModel.setAlamat1(alamat1);
		userModel.setAlamat2(alamat2);
		userModel.setAlamat3(alamat3);

		userService.tambah_data(userModel);

		model.addAttribute("userModel", userModel);

		return "redirect:/user/fe_list";
	}
	
	@RequestMapping("/user/search")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<UserModel> userModelList = userService.listAll(keyword);
		model.addAttribute("userModelList", userModelList);
		model.addAttribute("keyword", keyword);

		String html = "/user/fe_list";
		return html;
	}
	
	@RequestMapping("/user/delete_data")
	public String delete_user(HttpServletRequest request, Model model) {

		String nama_user = request.getParameter("nama_user");
		this.userService.delete_data(nama_user);

		return "redirect:/user/fe_list";
	}

	@RequestMapping("/user/detail_data")
	public String detail_user(HttpServletRequest request, Model model) {

		String nama_user = request.getParameter("nama_user");

		UserModel userModel = new UserModel();
		userModel = this.userService.detail_data(nama_user);

		model.addAttribute("userModel", userModel);

		return "/user/detail";
	}

	@RequestMapping("user/modal_hapus")
	public String modal_hapus() {
		return "user/modal-hapus";
	}

	@RequestMapping("user/modal_detail")
	public String modal_detail(HttpServletRequest request, Model model) {

		String nama_user = request.getParameter("nama_user");

		UserModel userModel = new UserModel();
		userModel = this.userService.detail_data(nama_user);

		model.addAttribute("userModel", userModel);

		return "user/modal-detail";
	}
	
	
	
}
