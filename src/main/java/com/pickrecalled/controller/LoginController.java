package com.pickrecalled.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

	@PostMapping(value = "/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
		if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) && "123456".equals(password.trim())) {
			// 将用户信息保存到session中
			session.setAttribute("loginUser", username);
			// 防止表单重复提交，所以重定向到main（redirect:/就是重定向到当前项目下）
			return "redirect:/main";
		} else {
			map.put("msg", "用户名与密码验证失败");
			return "login";
		}
	}

}
