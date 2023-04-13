package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.dao.StudentDao;
import com.spring.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {
	@Bean("ds")
	 public DriverManagerDataSource getDataSource() {
		 DriverManagerDataSource ds=new DriverManagerDataSource();
		 ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 ds.setUrl("jdbc:mysql://localhost:3306/company");
		 ds.setUsername("root");
		 ds.setPassword("system");
		 return ds;
	 }
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean("studentdao")
	public StudentDao getStudent() {
		StudentDaoImpl dao=new StudentDaoImpl();
		dao.setTemplate(getTemplate());
		return dao;
	}
	 
}
