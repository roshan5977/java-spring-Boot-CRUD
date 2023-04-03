package com.darkworldbank.user.service;

import java.util.List;

import com.darkworldbank.user.model.User;

public interface UserService {

	public User save(User user);

	public User get(int id);

	public List<User> getAllUsers();

	public User getByUserName(String UserName);

	public User getByUserNameAndAge(String UserName, int age);

	public void delete(int id);

}
