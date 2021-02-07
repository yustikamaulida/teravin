package com.teravin.task.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teravin.task.model.UserModel;
import com.teravin.task.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/api_post")
	public Map<String, Object> post_guru(@RequestBody UserModel userModel){
		
		this.userService.tambah_data(userModel);
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Ditambahkan");
		
		return map;
	}
	
	@GetMapping("/user/api_get")
	public Page<UserModel> getAll_user(Pageable pageable){
		
		Page<UserModel> userModelList = this.userService.listUser(pageable);
		
		return userModelList;
	}
	
	@GetMapping("/user/api_getById")
	public UserModel getById_user(@RequestParam String nama_user){
		
		UserModel userModel = new UserModel();
		userModel = this.userService.detail_data(nama_user);
		
		return userModel;
	}
	
	@DeleteMapping("/user/api_delete")
	public Map<String, Object> delete_user(@RequestParam String nama_user) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		this.userService.delete_data(nama_user);
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Hapus");
		
		return map;
	}
}
