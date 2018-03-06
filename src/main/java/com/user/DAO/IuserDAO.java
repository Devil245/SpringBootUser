package com.user.DAO;
import com.user.model.*;
import java.util.*;
public interface IuserDAO {
	
		public void save(User p);
		public List<User> getAllUsers();
		public List<User> getUsersByPage(int pageid, int total);
		public User getUserById(int id);
		public int count() ;
		public void update(User p);
		public void delete(int id);
		public void delete();

	}

