package com.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.DAO.UserDAO;
import com.user.model.User;

@Service
public class UserService implements IuserService{

	@Autowired
    UserDAO userdao;
	
	@Transactional
	public void save(User usr) {
		// TODO Auto-generated method stub
		userdao.save(usr);
		
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userdao.getAllUsers();
	}
	
	public List<User> getUsersByPage(int pageid, int total)
	{
		return userdao.getUsersByPage(pageid,total);
	}

	public int count() {
		// TODO Auto-generated method stub
		return userdao.count();
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userdao.getUserById(id);
	}

	public void update(User usr) {
		// TODO Auto-generated method stub
		 userdao.update(usr);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userdao.delete(id);
	}

	public void delete() {
		// TODO Auto-generated method stub
		userdao.delete();
	}

	

}
