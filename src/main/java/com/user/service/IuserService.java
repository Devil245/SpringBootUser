package com.user.service;

import com.user.model.User;
import java.util.*;

public interface IuserService {
	public void save(User user);
	public List<User> getAllUsers();
	public List<User> getUsersByPage(int pageid, int total);
	public User getUserById(int id);
	public int count() ;
	public void update(User u);
	public void delete(int id);
	public void delete();

}

