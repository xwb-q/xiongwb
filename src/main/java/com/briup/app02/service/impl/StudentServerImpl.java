package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Student;
import com.briup.app02.dao.StudentMapper;
import com.briup.app02.service.IStudentService;
@Service
public class StudentServerImpl implements IStudentService{
	@Autowired
	private StudentMapper studentMapper;
	
	
	@Override
	public List<Student> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Student> list=studentMapper.findAll();
		
		return list;
	}


	@Override
	public Student findStudentById(long id) throws Exception{
		// TODO Auto-generated method stub
		Student student=studentMapper.findById(id);
		if(student!=null)
		{
			return student;
		}
		else
			throw new Exception("查询失败");
		
	}


	@Override
	public void save(Student student) throws Exception {
		// TODO Auto-generated method stub
		studentMapper.save(student);
	}


	@Override
	public void update(Student student) throws Exception {
		// TODO Auto-generated method stub
		findStudentById(student.getId());
		studentMapper.update(student);
	}


	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		findStudentById(id);
		studentMapper.deleteById(id);
	}
	
}
