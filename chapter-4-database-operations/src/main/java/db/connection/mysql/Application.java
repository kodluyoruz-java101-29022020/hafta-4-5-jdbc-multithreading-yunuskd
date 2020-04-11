package db.connection.mysql;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import db.connection.mysql.connection.dao.DepartmentDAO;
import db.connection.mysql.connection.dao.EmployeeDAO;
import db.connection.mysql.connection.dao.ManagerDAO;
import db.connection.mysql.connection.dao.SalaryDAO;
import db.connection.mysql.connection.model.Employee;
import db.connection.mysql.connection.model.EmployeeProfile;
import db.connection.mysql.connection.service.DepartmentService;
import db.connection.mysql.connection.service.EmployeeService;
import db.connection.mysql.connection.service.ManagerService;
import db.connection.mysql.connection.service.SalaryService;

public class Application {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		showMenu();
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		SalaryDAO salaryDAO = new SalaryDAO();
		ManagerDAO managerDAO = new ManagerDAO();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		
		EmployeeService employeeService = new EmployeeService(employeeDAO);
		SalaryService salaryService = new SalaryService(salaryDAO);
		ManagerService managerService = new ManagerService(managerDAO);
		DepartmentService departmentService = new DepartmentService(departmentDAO);
		
		while(true) {
			
			int choice = makeProcessChoice();
			
			if(choice == 9) {
				break;
			}
			
			switch (choice) {
				case 1:
					showAllEmployees(employeeService);
					System.out.println();
					break;
				case 2:
					showEmployeeProfile(employeeService, salaryService);
					System.out.println();
					break;
				case 3:
					insertEmployee(employeeService);
					System.out.println();
					break;
				case 4:
					updateEmployee(employeeService);
					System.out.println();
					break;
				case 5:
					deleteEmployee(employeeService);
					System.out.println();
					break;
				case 6:
					showMenu();
					System.out.println();
					break;
				case 7:
					// burada aktif yöneticileri listeleyen bir fonksiyon yazmalısınız.
					break;
				case 8:
					// burada tüm departmanları listeleyiniz.
					break;
				default:
					break;
			}
			
		}
		
	}
	
	private static void showMenu() {
		
		System.out.println("1- Tüm çalışan listesi ");
		System.out.println("2- Çalışan profili sorgulama ");
		System.out.println("3- Yeni çalışan ekleme ");
		System.out.println("4- Çalışan verilerini güncelleme ");
		System.out.println("5- Çalışan silme ");
		System.out.println("6- Menüyü tekrar yazdır ");
		System.out.println("7- Aktif yöneticilik yapanları listele ");
		System.out.println("8- Departmanları listele ");
		System.out.println("9- Çıkış ");
	}
	
	public static int makeProcessChoice() {
		
		System.out.println("İşlem tercihinizi yapınız...");
		int choice = scanner.nextInt();
		return choice;
	}
	
	public static void showAllEmployees(EmployeeService employeeService) {
		
		Set<Employee> employees = employeeService.findAll();
		
		Iterator<Employee> iterator = employees.iterator();
		while(iterator.hasNext()) {
			
			Employee employee = iterator.next();
			System.out.println(employee);
		}
	}
	
	public static void showEmployeeProfile(EmployeeService employeeService, SalaryService salaryService) {
		
		System.out.println("Çalışan ID'sini giriniz: ");
		long empNo = scanner.nextLong();
		
		EmployeeProfile employeeProfile = employeeService.loadEmployeeProfile(empNo);
		
		if(employeeProfile == null) {
			System.out.println("Girdiğiniz ID değerine uygun bir çalışan profili bulunamamıştır");
			return;
		}
		
		List<Long> salaries = salaryService.getSalaries(empNo);
		employeeProfile.setSalaries(salaries);
		
		System.out.println(employeeProfile.getEmployee());
		System.out.println("Çalıştığı Departman: " + employeeProfile.getDepartmentName());
		System.out.println("Maaşları:");
		for(Long salary : employeeProfile.getSalaries()) {
			System.out.println(salary);
		}
	}
	
	public static void insertEmployee(EmployeeService employeeService) {
		
		System.out.println("Çalışan verilerini giriniz:");
		
		System.out.println("İsim");
		String name = scanner.nextLine();
		
		System.out.println("Soyismi");
		String lastName = scanner.nextLine();
		
		System.out.println("Cinsiyet (M veya F giriniz)");
		String gender = scanner.next();
		gender = String.valueOf(gender.charAt(0));
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setLastName(lastName);
		employee.setGender(gender);
		employee.setHireDate(new Date());
		employee.setBirthDate(new Date());
		
		employee = employeeService.save(employee);
		System.out.println("Yeni oluşturulan çalışan bilgileri");
		System.out.println(employee);
	}
	
	public static void updateEmployee(EmployeeService employeeService) {
		
		System.out.println("Çalışan verilerini giriniz:");
		
		System.out.println("Çalışan ID'sini giriniz: ");
		long empNo = scanner.nextLong();
		
		System.out.println("İsim");
		String name = scanner.nextLine();
		
		System.out.println("Soyismi");
		String lastName = scanner.nextLine();
		
		Employee employee = employeeService.update(empNo, name, lastName);
		
		System.out.println("Bilgileri güncellenen çalışan kaydı");
		System.out.println(employee);
	}
	
	public static void deleteEmployee(EmployeeService employeeService) {
		
		System.out.println("Çalışan ID'sini giriniz: ");
		long empNo = scanner.nextLong();
		
		boolean result = employeeService.delete(empNo);
		 
		if(!result) 
		{
			System.out.println("Girdiğiniz ID değerine sahip bir çalışan bulunmamaktadır");
			return;
		}
		else
		{
			System.out.println(empNo + " ID'li çalışan silinmiştir!");
		}
	}
	
	public static void listActiveManagers(ManagerService managerService) {
		
		// Burada ManagerService üzerinden aktif yöneticilerin listesini çekiniz ve ekrana yazdırınız
		
	}
	
	public static void listDepartments(DepartmentService departmentService) {
		
		// Burada tğm departmanları listeleyen ve ekrana gösteren kodu yazınız.
	}

}
