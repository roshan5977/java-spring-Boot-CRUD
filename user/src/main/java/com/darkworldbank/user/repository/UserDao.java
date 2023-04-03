package com.darkworldbank.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.darkworldbank.user.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	Optional<User> getByUserName(String userName);
	
	Optional<User> getByUserNameAndUserAge(String userName,int userAge);
	
//	@Query(name = "select * from User where userName=?1 ,age=?2")
//	Optional<User> getUsingUserNameAndUserAge(String userName,int age);

}
