package com.spring.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.entity.Student;

public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate template;
	public int insert(Student student) {
		 String sql="insert into student values(?,?,?);";
		int r= this.template.update(sql,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		System.out.println("injecting jdbcTemplate setters");
		this.template = template;
	}
	
	
	public int update(Student student) {
		String sql="update student set name=? , city =? where id=?";
		int r = this.template.update(sql,student.getName(),student.getCity(),student.getId());
		return r;
	
	}


	public int delete(int id) {
		String sql="delete from student where id=?;";
		int r = this.template.update(sql,id);
		return r;
	}


	public Student  getStudent(int id) {
		String sql="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student = this.template.queryForObject(sql,rowMapper,id);
		return student;
	}


	public List<Student> getAllStudent() {
		 String sql="select  * from student;";
//		 RowMapper<Student> rowMapper=new RowMapperImpl();
		 // you can do this by annonymous class
		 List<Student> list= this.template.query(sql,new RowMapperImpl());
		return list;
	}

}
