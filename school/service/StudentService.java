package com.school.service;

import com.school.dao.StudentDao;
import com.school.dto.Student;

public class StudentService {

	StudentDao studentDao = new StudentDao();
	
	public boolean deleteStudentById(int id) {
		return studentDao.deleteStudentById(id);
	}
	
	public Student saveStudent(Student student) {
		Student s = studentDao.saveStudent(student);
	    return s;
	}
	
	  public int getStudent(int id) {
		  return studentDao.getStudent(id); 
	  }
	  
	  public void getAll() {
		   studentDao.getAll();
	  }
	
}
