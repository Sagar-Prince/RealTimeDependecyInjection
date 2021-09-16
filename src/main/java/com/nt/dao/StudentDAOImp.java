package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.StudentBO;

//DAO class is a java class that contain persistance logic
public class StudentDAOImp implements StudentDAO {
	private static final String student_insert_query="insert into student3 values(?,?,?,?,?)";
	
	private DataSource ds;

	public StudentDAOImp(DataSource ds) {
		super();
		this.ds = ds;
	}
	
	public int insert(StudentBO bo) {
		//writing jdbc code to insert record
		try {
			//get jdbc connection
			Connection con = ds.getConnection();
			//create preparedStatement obj
			PreparedStatement ps = con.prepareStatement(student_insert_query);
			ps.setInt(1, bo.getSno());
			ps.setString(2, bo.getSname());
			ps.setInt(3, bo.getTotal());
			ps.setFloat(4, bo.getAvg());
			ps.setString(5, bo.getResult());
			
			//execute Query
			int result = ps.executeUpdate();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
	 }
		
		return 0;
	}
	
}
