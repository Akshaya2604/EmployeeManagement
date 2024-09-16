package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.Entity.Employee;
import com.service.EmpService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/displays")
public class DisplayAll extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpService empService=new EmpService();
		List<Employee> emps=empService.fetchAllEmployees();
		PrintWriter pr=resp.getWriter();
		
		pr.print("<!DOCTYPE html>\r\n"
		        + "<html lang=\"en\">\r\n"
		        + "<head>\r\n"
		        + "    <meta charset=\"UTF-8\">\r\n"
		        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
		        + "    <title>User Table</title>\r\n"
		        + "    <style>\r\n"
		        + "        body {\r\n"
		        + "            font-family: Arial, sans-serif;\r\n"
		        + "            background-color: #f4f4f4;\r\n"
		        + "            display: flex;\r\n"
		        + "            justify-content: center;\r\n"
		        + "            align-items: center;\r\n"
		        + "            height: 100vh;\r\n"
		        + "            margin: 0;\r\n"
		        + "        }\r\n"
		        + "        .container {\r\n"
		        + "            background-color: #fff;\r\n"
		        + "            padding: 20px;\r\n"
		        + "            border-radius: 10px;\r\n"
		        + "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
		        + "        }\r\n"
		        + "        table {\r\n"
		        + "            width: 100%;\r\n"
		        + "            border-collapse: collapse;\r\n"
		        + "            margin-top: 20px;\r\n"
		        + "        }\r\n"
		        + "        table, th, td {\r\n"
		        + "            border: 1px solid #ddd;\r\n"
		        + "        }\r\n"
		        + "        th, td {\r\n"
		        + "            padding: 10px;\r\n"
		        + "            text-align: left;\r\n"
		        + "        }\r\n"
		        + "        th {\r\n"
		        + "            background-color: #f2f2f2;\r\n"
		        + "        }\r\n"
		        + "        .action-link {\r\n"
		        + "            margin: 5px;\r\n"
		        + "            padding: 5px 10px;\r\n"
		        + "            font-size: 14px;\r\n"
		        + "            cursor: pointer;\r\n"
		        + "            text-decoration: none;\r\n"
		        + "            border-radius: 5px;\r\n"
		        + "            color: white;\r\n"
		        + "            transition: background-color 0.3s;\r\n"
		        + "        }\r\n"
		        + "        .link-edit {\r\n"
		        + "            background-color: #28a745;\r\n"
		        + "        }\r\n"
		        + "        .link-edit:hover {\r\n"
		        + "            background-color: #218838;\r\n"
		        + "        }\r\n"
		        + "        .link-delete {\r\n"
		        + "            background-color: #dc3545;\r\n"
		        + "        }\r\n"
		        + "        .link-delete:hover {\r\n"
		        + "            background-color: #c82333;\r\n"
		        + "        }\r\n"
		        + "    </style>\r\n"
		        + "</head>\r\n"
		        + "<body>\r\n"
		        + "    <div class=\"container\">\r\n"
		        + "        <h1>User Table</h1>\r\n"
		        + "        <table>\r\n"
		        + "            <thead>\r\n"
		        + "                <tr>\r\n"
		        + "                    <th>ID</th>\r\n"
		        + "                    <th>Name</th>\r\n"
		        + "                    <th>Age</th>\r\n"
		        + "                    <th>Email</th>\r\n"
		        + "                    <th>Salary</th>\r\n"
		        + "                    <th>Actions</th>\r\n"
		        + "                </tr>\r\n"
		        + "            </thead>\r\n"
		        + "            <tbody>");

		for (Employee employee : emps) {
			int id=employee.getId();
			String name=employee.getName();
			int age=employee.getAge();
			String emailid=employee.getEmail();
			double salary=employee.getSalary();
			
			 pr.print("<tr>\r\n"
		             + "    <td>" + id + "</td>\r\n"
		             + "    <td>" + name + "</td>\r\n"
		             + "    <td>" + age + "</td>\r\n"
		             + "    <td>" + emailid + "</td>\r\n"
		             + "    <td>" + salary + "</td>\r\n"
		             + "    <td>\r\n"
		             + "        <a href="+"editform.html"+">Edit</a>\r\n"
		             + "        <a href="+"deleteform.html"+">Delete</a>\r\n"
		             + "    </td>\r\n"
		             + "</tr>");
		 }
		
	}
	
}
