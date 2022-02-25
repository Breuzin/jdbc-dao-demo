package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST_1: test FindById ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST_2: test seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST_3: test seller FindAll ===");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST_4: test seller Insert ===");
		Seller seller1 = new Seller(null, "Gregory", "greg@gmail.com", new Date(), 5004.00, department);
		sellerDao.insert(seller1);
		System.out.println("Inserted! New id = " + seller1.getId());
	}

}
