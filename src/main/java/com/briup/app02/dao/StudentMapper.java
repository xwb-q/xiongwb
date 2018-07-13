package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Student;

public interface StudentMapper {
	List<Student> findAll();
	Student findById(long id);
	void save(Student student);
	void update(Student student);
	void deleteById(long id);
}
