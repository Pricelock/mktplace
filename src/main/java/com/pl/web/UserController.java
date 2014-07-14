package com.pl.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pl.service.UserManager;

@Controller
@RequestMapping("/hello" )
public class UserController implements
		org.springframework.web.servlet.mvc.Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private UserManager userManager;

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@RequestMapping("/hi")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("now", now);
		model.put("users", userManager.getUsers());
		return new ModelAndView("hello", "model", model);
	}

}
