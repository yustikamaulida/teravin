package com.teravin.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teravin.task.model.UserModel;
import com.teravin.task.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Page<UserModel> listUser(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findAll(pageable);
	}

	public List<UserModel> listUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public void tambah_data(UserModel userModel) {
		// TODO Auto-generated method stub
		userRepository.save(userModel);
	}
	
	public List<UserModel> listAll(String keyword) {
		if (keyword != null) {
			return userRepository.search(keyword);
		}
		return userRepository.findAll();
	}

	public UserModel detail_data(String nama_user) {
		// TODO Auto-generated method stub
		return userRepository.getId(nama_user);
	}

	public void delete_data(String nama_user) {
		// TODO Auto-generated method stub
		userRepository.deleteById(nama_user);
	}
}
