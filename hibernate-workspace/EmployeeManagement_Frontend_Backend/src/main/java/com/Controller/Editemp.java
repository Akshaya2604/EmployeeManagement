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

@WebServlet(value = "/submit")
public class Editemp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String email = req.getParameter("emailid");
		String salaray = req.getParameter("salary");

		int ids = Integer.parseInt(id);
		int agess = Integer.parseInt(age);
		int salarys = Integer.parseInt(salaray);

		Employee e = new Employee(ids, name, agess, email, salarys);
		
		EmpService empService = new EmpService();
		int res = empService.updateEmployee(e);
		if (res != 0) {
			RequestDispatcher rsdp = req.getRequestDispatcher("Welcome.html");

			rsdp.include(req, resp);
		}

	}

}
