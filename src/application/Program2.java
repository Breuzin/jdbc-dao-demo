package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.println("=== TEST_1: test department insert ===");
		Department department = new Department(5, "Books");
		departmentDao.insert(department);
		System.out.println("New department created: " + department);
		*/
		
		System.out.println("\n=== TEST_2: test department FindByID ===");
		System.out.print("Enter with test id: ");
		int id = sc.nextInt();
		System.out.printf("Department id=%d is %s\n", id, departmentDao.findById(id));
		
		System.out.println("\n=== TEST_3: test department update ===");
		Department dep1 = departmentDao.findById(16);
		dep1.setName("Phones");
		departmentDao.update(dep1);
		
		System.out.println("\n=== TEST_4: test department delete ===");
		departmentDao.deleteById(17);
		System.out.println("Department delete! ");
		
		System.out.println("\n=== TEST_5: test department FindAll ===");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);

		sc.close();
	}

}
