package com.mss;


import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String home() {
		return "home";
//		return new ModelAndView("SideMenu.html");
	}

	@RequestMapping("/setValue")
	public String setValue(@RequestParam(name = "key", required = false) String key,
			@RequestParam(name = "value", required = false) String value,
			HttpServletRequest request) {
		if (!ObjectUtils.isEmpty(key) && !ObjectUtils.isEmpty(value)) {
			request.getSession().setAttribute(key, value);
		}
		return "home";
	}
}
