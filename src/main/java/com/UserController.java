package com;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.model.*;
import com.user.service.UserService;
import com.user.DAO.*;

@Controller
public class UserController {
	
	 @Autowired
	private UserService udao;
	 
	 @RequestMapping("/hello")
	 @ResponseBody
	 public ModelAndView index() {
		 ModelAndView mav=new ModelAndView("hello");
		 mav.addObject("abc", "hb");
		 return mav;
	 }
	
	@RequestMapping(value ="/add",method = RequestMethod.GET)
	public ModelAndView newRegistration() {
		ModelAndView mav=new ModelAndView("add");
		 return mav; 

	}
	
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public ModelAndView saveRegistration(@RequestParam("firstName") String fname,@RequestParam("lastName") String lname,@RequestParam("city") String city,@RequestParam("profession") String profession ) {

		User u=new User();
		u.setFname(fname);
		u.setLname(lname);
		u.setCity(city);
		u.setProfession(profession);
		udao.save(u);
		ModelAndView mav=new ModelAndView("viewusers");
		mav.addObject("user",u);
		return new ModelAndView("redirect:/viewusers/1");  
	}
	
	@RequestMapping("/viewusers")  
    public ModelAndView viewusers(){  
        
		 List<User> list=udao.getAllUsers();
	        return new ModelAndView("viewusers","list",list);      } 
	
	/* It opens the student list for the given page id */
	@RequestMapping(value="/viewusers/{pageid}")  
    public ModelAndView edit(@PathVariable int pageid){  
        int total=2;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<User> list=udao.getUsersByPage(pageid,total);  
          
        return new ModelAndView("viewusers","list",list);  
    }
	
	/* It opens the record for the given id in edit user page */
	 @RequestMapping(value="/edituser/{id}")  
	    public String edit(@PathVariable int id,ModelMap model){  
	       User u1=udao.getUserById(id);  
	       model.addAttribute("user", u1);
			return "edituser";
	        
	        
	    } 
	 
	 /* It updates record for the given id in edit user page and redirects to /viewusers */  
	 @RequestMapping(value="/editsave",method = RequestMethod.PUT)  
	    public ModelAndView editsave(@ModelAttribute("user") User emp){  
	    	System.out.println("id is"+emp.getId());
	    	udao.update(emp);  
	        return new ModelAndView("redirect:/viewusers/1");  
	    }  
	 
	 /* It deletes record for the given id  and redirects to /viewusers */  
	    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.DELETE)  
	    public ModelAndView delete(@PathVariable int id){  
	    	udao.delete(id);  
	        return new ModelAndView("redirect:/viewusers/1");  
	    }  
	    
	    /* It deletes record for the given id  and redirects to /viewusers */  
	    @RequestMapping(value="/delete",method = RequestMethod.DELETE)  
	    public ModelAndView delete(){  
	    	udao.delete();  
	        return new ModelAndView("redirect:/viewusers");  
	    }  
	

	
	/*
	 * Method used to populate the Section list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	 @ModelAttribute("pageCount")
		public List<String> initializePageCount() {
		    int total=2;  
			List<String> pageCount = new ArrayList<String>();
			int count=udao.count(); 
			int result=((count/total)+ (count%total));
			for(int k=0;k<result;k++) {
				pageCount.add(new Integer(k).toString());
			}
			
			return pageCount;
		}

}