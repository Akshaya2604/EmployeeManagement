package com.Controller;

import java.io.IOException;

import com.service.EmpService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/delete")
public class Deleteemp extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ids = req.getParameter("id");
		int id = Integer.parseInt(ids);

		EmpService empService = new EmpService();
		int res = empService.deleteEmployee(id);
		if (res != 0) {
			RequestDispatcher rsdp = req.getRequestDispatcher("Welcome.html");
			rsdp.include(req, resp);
		}
		
	}

}
