package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

//its a service class that contain business logic
public class StudentServiceImp implements StudentService {

	private StudentDAO dao;
	
	public StudentServiceImp(StudentDAO dao) {
		super();
		this.dao = dao;
	}


	public String generateResult(StudentDTO dto) {
		//write b.logic
		
		int total=dto.getM1()+dto.getM2()+dto.getM3();
		float avg=(float)total/0.3f;
		String result=null;
		
		if(avg<35) {
			result="fail";
		}else {
			result="pass";
		}
		
		//create BO class object
		StudentBO bo=new StudentBO();
		bo.setAvg(avg);
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setSno(dto.getSno());   
		bo.setResult(result);
		//use DAO
		int insert = dao.insert(bo);
		
		if(insert==0) 
			return "result :"+bo.getResult()+"  "+bo.getSno()+" Registration failed";
		else 
			return "Result : "+bo.getResult()+"  "+bo.getSno()+" Registration passed";
	}//method
	
	
}//end of class
