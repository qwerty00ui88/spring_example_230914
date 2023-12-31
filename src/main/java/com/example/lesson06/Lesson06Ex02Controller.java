package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원 가입 화면
	// http://localhost/lesson06/ex02/add-user-view
	@GetMapping("/add-user-view")
	public String addUserView() {
		return "/lesson06/ex02AddUser";
	}
	
	// 이름 중복 확인 - AJAX 요청
	// http://localhost/lesson06/ex02/is-duplication-name
	@GetMapping("/is-duplication-name")
	@ResponseBody
	public Map<String, Object> isDuplicationName(@RequestParam("name") String name) {
		// select
		boolean isDuplication = userBO.isDuplicationByName(name);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		
		return result;
	}
	
}
