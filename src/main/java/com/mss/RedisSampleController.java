package com.mss;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisSampleController {

	@GetMapping("/")
	String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return uid.toString();
	}
}
