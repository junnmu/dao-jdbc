package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: seller findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== TEST 2: seller findAll ===");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller insert ===");
        Department newDepartment = new Department(null, "Programming");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Id = " + newDepartment.getId());

        System.out.println("\n=== TEST 4: seller update ===");
        department = departmentDao.findById(2);
        department.setName("Mecatronics");
        departmentDao.update(department);
        System.out.println("Updated!");

        System.out.println("\n=== TEST 5: seller delete ===");
        System.out.println("Enter id for deletetion: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Department deleted!");
    }
}
