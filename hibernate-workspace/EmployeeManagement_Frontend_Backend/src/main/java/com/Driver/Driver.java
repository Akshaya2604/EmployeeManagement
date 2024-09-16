package com.Driver;

import java.util.List;

import com.Entity.Employee;
import com.service.EmpService;

public class Driver {

	public static void main(String[] args) {

//		Employee e=new Employee(2, "Raksha", 23,"rakshu@gmail.com", 26000);
		
		EmpService empService = new EmpService();
		
//		int res=empService.save(e);
//		if (res!=0) {
//			System.out.println("data is stored");
//		}
//		int res=empService.update(e);
//		if (res!=0) {
//			System.out.println("data is updated");
//		}

//		int res=empService.delete(3);
//		if (res!=0) {
//			System.out.println("data deletd");
//		}
		
		List<Employee> emps = empService.fetchAllEmployees();
		for (Employee employe : emps) {
			System.out.println(employe.getId() + ": " + employe.getName() + ": " + employe.getAge() + ": "+ employe.getEmail() + ": " + employe.getSalary());
		}

	}

}
