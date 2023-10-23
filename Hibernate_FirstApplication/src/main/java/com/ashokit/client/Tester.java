package com.ashokit.client;

import com.ashokit.dao.StudentDAO;
import com.ashokit.dao.impl.StudentDAOImpl;
import com.ashokit.entity.Student;

public class Tester {

	public static void main(String[] args) {

		StudentDAO dao = new StudentDAOImpl();

		//SAVE student obje to database
		/*
		 * Student student = new Student(); 
		 * student.setSid(1);
		 * student.setSname("Wilson"); 
		 * student.setGender("Male");
		 * student.setMarks(100);;
		 * 
		 * dao.saveStudent(student);
		 */
		 
		//2. get student object fro db
		
//		Student loadStudent = dao.loadStudent(1);
//		//System.out.println(loadStudent);
		
		//3. update student object 
		/*
		 * Student updateStudent = dao.updateStudent(2, 100);
		 * System.out.println(updateStudent);
		 */
		
		//4. delete object from db
		
		dao.deleteStudent(2);
	}

}
