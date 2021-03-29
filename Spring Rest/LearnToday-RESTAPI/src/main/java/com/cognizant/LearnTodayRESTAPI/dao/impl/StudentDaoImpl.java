package com.cognizant.LearnTodayRESTAPI.dao.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.cognizant.LearnTodayRESTAPI.dao.StudentDao;
import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidEnrollmentIdException;
import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.model.Student;
import com.cognizant.LearnTodayRESTAPI.rowmapper.CourseRowMapper;
import com.cognizant.LearnTodayRESTAPI.rowmapper.StudentRowMapper;
@Repository
public class StudentDaoImpl implements StudentDao {
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/rest");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@54");
		return dataSource;
	}

	JdbcTemplate template = new JdbcTemplate(dataSource());
	//private JdbcTemplate template;
	
		
	public StudentDaoImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}


	

	public StudentDaoImpl() {
		// TODO Auto-generated constructor stub
		super();
	}




	@Override
	public int register(Student student) throws DuplicateKeyException, DataIntegrityViolationException{
		String sql = "insert into student values (?,?,?)";
		int inserted = template.update(sql, student.getEnrollmentId(), student.getStudentId(), student.getCourseId());
		return inserted;
	}

	@Override
	public Course getCourseById(int courseId) {
		String sql = "select * from course where CourseId=?";
		CourseRowMapper crm = new CourseRowMapper();
		Course course = template.queryForObject(sql, crm, courseId);
		return course;
	}

	@Override
	public int delete(int enrollmentId) throws InvalidEnrollmentIdException {
		String sql = "delete from student where EnrollmentId =?";
		int deleted= template.update(sql, enrollmentId);
		if(deleted==0) {
			throw new InvalidEnrollmentIdException("No enrollment information found");
		}
		return deleted;
	}
	
	@Override
	public List<Student> getStudentByCourseId(int courseId){
		String sql = "select enrollmentid, studentid, s.courseid from student s, course c where c.courseId = s.courseId and c.courseId =?";
		StudentRowMapper srm = new StudentRowMapper();
		List<Student> students = template.query(sql, srm, courseId);
		return students;
	}

}
