package com.darkworldbank.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkworldbank.user.model.User;
import com.darkworldbank.user.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User save(User user) {
		return userDao.save(user);		
	}

	@Override
	public User get(int id) {
//		return userDao.getReferenceById(id);
		return userDao.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getByUserName(String UserName) {
		return userDao.getByUserName(UserName).get();
	}

	@Override
	public User getByUserNameAndAge(String UserName, int age) {
		return userDao.getByUserNameAndUserAge(UserName, age).get();
	}

	@Override
	public void delete(int id) {
		userDao.delete(userDao.getReferenceById(id));		
	}
	
	
}
