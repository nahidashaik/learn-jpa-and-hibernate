package com.nahida.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nahida.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.nahida.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.nahida.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
//	@Autowired
//	private CourseJdbcRepository repository;	
//	@Autowired
//	private CourseJpaRepository repository;
	@Autowired
	private CourseSpringDataJpaRepository repository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1, "Learn Java Jpa", "Nahida"));
		repository.save(new Course(2, "Learn algebra Jpa", "Jabbi"));
		repository.save(new Course(3, "Learn geometry Jpa", "Ray"));
		repository.save(new Course(4, "Learn algebra2 Jpa", "Naz"));
		repository.save(new Course(5, "Learn calculus Jpa", "Aym"));
		repository.deleteById(4l);
	
		System.out.println("repository for 2 "+repository.findById(2l));
		//System.out.println(repository.findById(4));
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor(""));
		System.out.println(repository.findByName("Learn Java Jpa"));
		System.out.println(repository.findByName("Learn algebra Jpa"));
	}

}
