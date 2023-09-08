package com.school.controller;

import com.school.service.StudentService;

public class StudentGetAll {

	public static void main(String[] args) {
		StudentService studentService= new StudentService();
		studentService.getAll();
	}
}
