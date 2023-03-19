package com.nahida.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nahida.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	@Autowired
	private JdbcTemplate sprinJdbcTemplate;
	private static String INSERT_QUERY=
			"""
insert into course(id, name, author)
					values(?, ?, ?);
					""";
	private static String DELETE_QUERY=
			"""
					delete from course where id=?;
					""";
	private static String SELECT_QUERY=
			"""
					select * from course where id=?;
					""";
	public void insert(Course course) {
		sprinJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	public void deleteById(int id) {
		sprinJdbcTemplate.update(DELETE_QUERY, id);
	}
	//resultset -> bean  ->Row Mapper
	public Course findById(int id) {
		return sprinJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
		
	}
}
