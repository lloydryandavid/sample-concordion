package org.lloydryandavid.loginapp.controller;

import java.util.Arrays;
import java.util.List;

import org.lloydryandavid.loginapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
    	ModelAndView model = new ModelAndView();
    	model.addObject("users", getUsers());
    	model.setViewName("dashboard");
    	return model;
    }

	private List<User> getUsers() {
		User user = new User();
		user.setEmail("lloydryan.david@gmail.com");
		user.setName("Lloyd Ryan David");
		user.setAddress("Quezon City, Philippines");
		return Arrays.asList(user);
	}

}
