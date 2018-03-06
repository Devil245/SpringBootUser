package com.user.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import com.user.model.*;

@Service
public class UserDAO implements IuserDAO {
	
	
	JdbcTemplate template;  
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	
	
	public void save(User p) {
				
		String sql="insert into user(fname,lname,city,profession) values('"+p.getFname()+"','"+p.getLname()+"','"+p.getCity()+"','"+p.getProfession()+"')";
		System.out.println(sql);
	     template.update(sql);  
	}
	
	public List<User> getAllUsers() {
		
		
		return template.query("select * from user",new ResultSetExtractor<List<User>>(){  
		    
		     public List<User> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<User> list=new ArrayList<User>();  
		        while(rs.next()){  
		        User e=new User(); 
		        e.setId(rs.getInt(1));
		        e.setFname(rs.getString(2));  
		        e.setLname(rs.getString(3));  
		        e.setCity(rs.getString(4));
		        e.setProfession(rs.getString(5));
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  
		
		  }
	
	public List<User> getUsersByPage(int pageid, int total) {
		// TODO Auto-generated method stub
		 String sql="select * from user limit "+(pageid-1)+","+total;  
		 return template.query(sql,new ResultSetExtractor<List<User>>(){  
		    
		     public List<User> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<User> list=new ArrayList<User>();  
		        
		        while(rs.next()){  
		        User e=new User();  
		        e.setFname(rs.getString(1));  
		        e.setLname(rs.getString(2));  
		        e.setCity(rs.getString(3));
		        e.setProfession(rs.getString(4));
		       
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  }
	
	public User getUserById(int id) {
		// TODO Auto-generated method stub
				 return template.query("select * from user where ID="+id,new ResultSetExtractor<User>(){  
					    
				     public User extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
				      
				    	 User e=new User();  
				        while(rs.next()){  
					        e.setFname(rs.getString(1));  
					        e.setLname(rs.getString(2));  
					        e.setCity(rs.getString(3));
					        e.setProfession(rs.getString(4));
					        
				        }  
				        return e;  
				        }  
				    });  
			}
	



	public int count() {
		String sql="select count(*) from user";
		int count = template.queryForObject(sql,Integer.class);
		return count;
		  }



	public void update(User p) {
		String sql="update user set firstName='"+p.getFname()+"',lastName='"+p.getLname()+"',City='"+p.getCity()+"',Profession='"+p.getProfession()+"' where ID="+p.getId()+"";
		System.out.println(sql);
       template.update(sql);  
	}



	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from user where ID="+id+"";  
	    template.update(sql);  
		
	}



	public void delete() {
		// TODO Auto-generated method stub
		String sql="delete from user where ID>0";  
	    template.update(sql); 
	}

}
