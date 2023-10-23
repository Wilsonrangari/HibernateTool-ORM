package com.ashokit.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.ashokit.dao.StudentDAO;
import com.ashokit.entity.Student;

public class StudentDAOImpl implements StudentDAO {

	SessionFactory factory;

	//constructor
	public StudentDAOImpl() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		factory = metadata.getSessionFactoryBuilder().build();
	}

	@Override
	public void saveStudent(Student student) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {

			session.save(student);
			
			System.out.println("student object persisted in database");
			t.commit();

		} catch (Exception e) {
			t.rollback();
			System.out.println("Issue in persisting Student object");
			System.out.println(e);
		} finally {
			session.close();
			factory.close();
		}

	}

	@Override
	public Student loadStudent(int sid) {
		
		/*
		 * load() :: lazy loading
		 * get() :: early loading
		 * args  :: 1. Classname.name
		 *  		 2. id value	
		 */
		
		Session session = factory.openSession();
		Student student = session.get(Student.class, sid);
		
		session.close();
		return student;

	}
	@Override
	public Student updateStudent(int sid, int marks) {
		
		Session session =factory.openSession();
		Student s = session.get(Student.class, sid);
		Transaction t = session.beginTransaction();
		
		try {
			s.setMarks(marks);
			System.out.println("student object updated " + marks);
			t.commit();
		} catch (Exception e) {
			System.out.println("Student object not updated");
			t.rollback();
		}
		finally {
			
			session.close();
			factory.close();
			
		}
		return s;
	}
	
	@Override
	public void deleteStudent(int sid) {
		
		Session session = factory.openSession();
		Student s = session.get(Student.class, sid);
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(s);
			System.out.println("Object is deleted "+ sid);
			t.commit();
			
		} catch (Exception e) {
			System.out.println("object is not deleted");
			t.rollback();
		}
		finally {
			session.close();
		}
		
		
	}

}
