package db.connection.mysql.connection.service;

import db.connection.mysql.connection.dao.DepartmentDAO;

public class DepartmentService {

	private DepartmentDAO departmentDAO;
	
	public DepartmentService(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
	// burada tüm departmanları listeleyen fonksiyonu yazınız.
}
