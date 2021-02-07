package com.teravin.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teravin.task.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

    @Query("SELECT U FROM UserModel U WHERE U.nama_user LIKE %?1%")
    public List<UserModel> search(String keyword);

    @Query("SELECT U FROM UserModel U WHERE U.nama_user = ?1")
	UserModel getId(String nama_user);

}
