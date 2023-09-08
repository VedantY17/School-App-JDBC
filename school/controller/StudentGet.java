package com.school.controller;

import com.school.dto.Student;
import com.school.service.StudentService;

public class StudentGet {

	public static void main(String ars[]) {
		StudentService studentService= new StudentService();
		int res= studentService.getStudent(1);

	}
}