package com.cognizant.LearnTodayRESTAPI.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.cognizant.LearnTodayRESTAPI.dao.CourseDao;
import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.rowmapper.CourseRowMapper;
@Repository
public class CourseDaoImpl implements CourseDao{
	
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/rest");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@54");
		return dataSource;
	}

	JdbcTemplate template = new JdbcTemplate(dataSource());

	@Override
	public List<Course> getAllCourses() {
		String sql = "select * from course";
		CourseRowMapper crm = new CourseRowMapper();
		List<Course> courses = template.query(sql, crm);
		return courses;
	}

	@Override
	public List<Course> getCourseById(int courseId) {
		String sql = "select * from course where courseId=?";
		CourseRowMapper crm = new CourseRowMapper();
		return template.query(sql, crm, courseId);
	}

}
