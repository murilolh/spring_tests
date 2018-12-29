package com.spring.tests.employeeservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.tests.employeeservices.dao.EmployeeDao;
import com.spring.tests.employeeservices.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping
	public ModelAndView listAll() {
		ModelAndView modelAndView = new ModelAndView("employee-listAll.jsp");
		modelAndView.addObject("employees", employeeDao.findAll());

		return modelAndView;
	}

	@PostMapping("/create")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("employee-form.jsp");
		modelAndView.addObject("employee", new Employee());

		return modelAndView;
	}

	@PostMapping("/save")
	public RedirectView salvar(Employee employee, RedirectAttributes redirectAttributes) {
		employeeDao.save(employee);

		redirectAttributes.addFlashAttribute("msg", "Employee saved!");

		return new RedirectView("/employees", true);
	}

	@GetMapping("/update")
	public ModelAndView update(@RequestParam Long id) {
		ModelAndView modelAndView = new ModelAndView("employee-form.jsp");
		modelAndView.addObject("funcionario", employeeDao.findById(id));

		return modelAndView;
	}
}
