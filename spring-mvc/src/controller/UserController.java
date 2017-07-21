package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import service.UserService;

import entity.User;
import entity.page;
import entity.stu;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("/getAll")
	public String show1(Model m) {
		List<User> list = service.getAll();
		m.addAttribute("l", list);
		return "index";
	}

	@RequestMapping(value = "/getPage", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getPage(String name, String address, Integer pageNo) {
		Map<String, Comparable<?>> map = new HashMap<String, Comparable<?>>();
		map.put("name", name);
		map.put("address", address);
		map.put("pageNo", pageNo);
		page Page = service.getPage(map);
		return JSON.toJSONString(Page);

	}

	@RequestMapping("/getStu")
	public Object getStu() {
		stu Stu = new stu();
		Stu.setId(20);
		Stu.setName("yang");

		return Stu;

	}
}
