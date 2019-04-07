package com.pickrecalled.controller;

import com.pickrecalled.dao.DepartmentDao;
import com.pickrecalled.dao.EmployeeDao;
import com.pickrecalled.model.Department;
import com.pickrecalled.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 员工处理类
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	/**
	 * 查询所有员工信息返回列表页面
	 * @return
	 */
	@GetMapping("/emps")
	public String list(Model model) {
		// 查询所有员工信息
		Collection<Employee> employees = employeeDao.getAll();
		// 将要返回的数据放到请求域中共享
		model.addAttribute("emps", employees);
		return "emp/list";
	}

	/**
	 * 来到添加页面
	 * @return
	 */
	@GetMapping("/emp")
	public String toAddPage(Model model) {
		// 获取部门数据
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depms", departments);
		return "emp/add";
	}

	/**
	 * 添加员工
	 * @return
	 */
	@PostMapping("/emp")
	public String add(Employee employee) {
		employeeDao.save(employee);
		// redirect:表示重定向到一个地址，"/"代表当前项目路径
		// forward:表示转发到一个地址
		return "redirect:/emps";
	}

	/**
	 * 来到修改页面（查出员工信息回显）
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/emp/{id}")
	public String toEditPage(@PathVariable("id") Integer id, Model model) {
		// 获取员工信息
		Employee employee = employeeDao.get(id);
		model.addAttribute("emp", employee);
		// 获取部门数据
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depms", departments);
		return "emp/add";
	}

	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 */
	@PutMapping("/emp")
	public String update(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}

	/**
	 * 删除员工信息
	 * @return
	 */
	@DeleteMapping("/emp/{id}")
	public String delete(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
