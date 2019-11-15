package Tuan8.KeThuaDaHinhNew;

import java.util.ArrayList;
import java.util.Collections;

public class SoftwareHouse {
	private String theName;
	private ArrayList<Employee> list = new ArrayList<Employee>();
	
	public SoftwareHouse(String name) {
		this.theName = name;
	}

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}
	
	public ArrayList<Employee> getList() {
		return list;
	}

	public boolean addEmployee(Employee e) {
		for(Employee ex: list)
			if(ex.getThePayrollNumber() == e.getThePayrollNumber())	
				return false;
		list.add(e);
		return true;
	}
	
	public void displayAllStaff() {
		System.out.printf("%-15s %-30s %12s %20s\n","PayrollNo.","Name","Salary","Position");
		for(Employee ex: list)
			System.out.println(ex);
	}
	
	public double getMonthlySalaryBill() {
		double total = 0;
		for(Employee ex: list)
			total += ex.getMonthlySalary();
		return total;
	}
	
	public void sortAllStaffByName() {
		Collections.sort(list, Employee.nameComp);
	}
	
	public void DisplayListProgrammers() {
		System.out.printf("%-15s %-30s %12s %20s\n","PayrollNo.","Name","Salary","Position");
		for(Employee ex: list)
			if(ex instanceof Programmer)
				System.out.println(ex);
	}
	
	public boolean updateDepartmentForAdmin(int aPayrollNo, String deptNew) {
		for(Employee ex: list)
			if(ex instanceof Administrator)
				if(ex.getThePayrollNumber() == aPayrollNo) {
					((Administrator) ex).setTheDepartment(deptNew);
					return true;
				}
		return false;
	}
	
}
