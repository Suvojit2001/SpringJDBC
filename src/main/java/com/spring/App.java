package com.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.dao.StudentDao;
import com.spring.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws RuntimeException
    {
//    	 springJdbc =>> jdbcTemplate
     /*  ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/config.xml");
     JdbcTemplate template= (JdbcTemplate) context.getBean("jdbcTemplate");
       
     // insert query
     String sql="insert into student values(?,?,?);";
     
     //fire query
     int result =template.update(sql,101,"suvo","kolkata");
     System.out.println("number of result inserted : " +result);          */
    	
    	
    	//Company process of insert using Dao
    	  ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/config.xml");
    	StudentDao dao=  (StudentDao) context.getBean("studentdao");
    /*  Student student=new Student(102,"sourav","mumbai");
    	int insert = dao.insert(student);
    	System.out.println(insert + " row inserted");             */
    	
    	// How to update 
    	
    /*	Student student =new Student(101,"Argha","lukhnow");
    	int r = dao.update(student);
    	System.out.println( r + " row updated");   */
    	
    	
    	// how to delete 
    	
//    	int r = dao.delete(102);
//    	System.out.println(r +" row deleted");
    	
    	// how fire select Query
    	
//    	Student student =dao.getStudent(101);
//    	System.out.println(student);
    	
    	List<Student> list = dao.getAllStudent();
    	for(Student l1:list) {
    		System.out.println(l1.getName());
    	}
    	
    	
    	// you can also do the same which we have done in xml using java class only the first line 
    	// you have to change
//    	ApplicationContext context1=new AnnotationConfigApplicationContext(JdbcConfig.class);
//    	StudentDao studentDao=context1.getBean("studentdao",StudentDao.class);
    	
    }
}
