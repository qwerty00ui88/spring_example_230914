package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// http://localhost/lesson07/ex01/1
	// c: create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "김바다";
		String phoneNumber = "010-1111-2222";
		String email = "sbr@kakao.com";
		String dreamJob = "개발자";
		
		// 방금 인서트된 pk id도 바로 얻어낼 수 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// http://localhost/lesson07/ex01/2
	// u: update
	@GetMapping("/2")
	public StudentEntity update() {
		// id가 5번인 dreamJob 변경
		// 5, 디자이너
		return studentBO.updateStudentDreamJobById(5, "디자이너");
	}
	
	// http://localhost/lesson07/ex01/3
	// d: delete
	@GetMapping("/3")
	public String delete() {
		// id: 6
		studentBO.deleteStudentById(6);
		return "삭제 완료";
	}
}
