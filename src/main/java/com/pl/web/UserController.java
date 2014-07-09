package com.pl.web;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class UserController implements org.springframework.web.servlet.mvc.Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	@RequestMapping("/hi")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);

		return new ModelAndView("hello","now",now);
	}

}
