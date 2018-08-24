package com.pickrecalled.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TestController {

	@RequestMapping("/success")
	public String success(Map<String, Object> map) {
		map.put("promptMessage", "欢迎访问主页");
		return "success";
	}
}
