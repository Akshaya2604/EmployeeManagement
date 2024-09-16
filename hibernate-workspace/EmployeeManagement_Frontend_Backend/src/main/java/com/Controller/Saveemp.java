package com.Controller;

import java.io.IOException;

import com.Entity.Employee;
import com.service.EmpService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/save")
public class Saveemp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String salary = req.getParameter("salary");

		int ids = Integer.parseInt(id);
		int salarys = Integer.parseInt(salary);
		int ages = Integer.parseInt(age);

		Employee e = new Employee();
		e.setId(ids);
		e.setName(name);
		e.setAge(ages);
		e.setEmail(email);
		e.setSalary(salarys);
		EmpService empService = new EmpService();
		int res = empService.createEmployee(e);
		if (res != 0) {
			RequestDispatcher rs = req.getRequestDispatcher("Welcome.html");
			rs.include(req, resp);

		} else {
			RequestDispatcher rs = req.getRequestDispatcher("Welcome.html");
			rs.include(req, resp);

		}

	}

}
