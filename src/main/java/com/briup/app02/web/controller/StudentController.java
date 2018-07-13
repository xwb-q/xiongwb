package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/Student")
public class StudentController {
	//注入studentService的实例
	@Autowired
	private IStudentService studentService;
	
	
	//http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllStudent")
	public MsgResponse findAllStudent(){
		try {
			return MsgResponse.success("查询全体信息成功",studentService.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MsgResponse.error("查询失败:"+e.getMessage());
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findStudentById")
	public MsgResponse findStudentById(long id) {
		try {
			return MsgResponse.success("查询成功", studentService.findStudentById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error("查询失败:"+e.getMessage());
		}
		
	}
	/**
	 * 保存学生信息
	 * @author xwb
	 * @param student
	 * return 
	 */
	@PostMapping("save")
	public MsgResponse save(Student student)
	{
		try {
			studentService.save(student);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error("保存失败:"+e.getMessage());
		}
	}
	/**
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping("update")
	public MsgResponse updata(Student student)
	{
		try {
			studentService.update(student);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			
			return MsgResponse.error("更新失败："+e.getMessage());
		}
		
	}
	
	@DeleteMapping("deleteById")
	public MsgResponse deleteById(long id)
	{
		try {
			studentService.deleteById(id);
			return MsgResponse.success("删除成功：", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error("更新失败："+e.getMessage());
		}
		
	}
}
