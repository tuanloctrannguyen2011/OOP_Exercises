package Tuan8.KeThuaDaHinhNew;

import java.util.Comparator;

public abstract class Employee {
	protected int thePayrollNumber;
	protected String theName;
	protected double theBasicMonthlySalary;
	
	public Employee(int number, String name, double basic){
		this.thePayrollNumber = number;
		this.theName = name;
		this.theBasicMonthlySalary = basic;
	}
	
	public int getThePayrollNumber() {
		return thePayrollNumber;
	}

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public double getTheBasicMonthlySalary() {
		return theBasicMonthlySalary;
	}

	public void setTheBasicMonthlySalary(double theBasicMonthlySalary) {
		this.theBasicMonthlySalary = theBasicMonthlySalary;
	}
	
	public static Comparator<Employee> nameComp =  new Comparator<Employee>() {
		public int compare(Employee no1, Employee no2) {
			
			String name1 = no1.getTheName();
			String name2 = no2.getTheName();
			
			return name1.compareToIgnoreCase(name2);
		}
	};
	
	abstract double getMonthlySalary();

	@Override
	public String toString() {
		return String.format("%-15d %-30s", this.thePayrollNumber, this.theName);
	}

	public double getMonthlySalery() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
