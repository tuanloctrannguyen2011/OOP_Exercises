package Tuan8.KeThuaDaHinhNew;

import java.text.NumberFormat;
import java.util.Locale;

public class Administrator extends Employee{
	private String theDepartment;
	
	public Administrator(int number, String name, double basic, String department) {
		super(number,name,basic);
		this.theDepartment = department;
	}
	
	public String getTheDepartment() {
		return theDepartment;
	}

	public void setTheDepartment(String theDepartment) {
		this.theDepartment = theDepartment;
	}

	public String toString() {
		Locale VN = new Locale("vn","vn");
		NumberFormat nf = NumberFormat.getCurrencyInstance(VN);
		return String.format("%-15d %-30s %12s %20s", this.thePayrollNumber, this.theName, nf.format(getMonthlySalary()),this.theDepartment);
	}

	@Override
	public double getMonthlySalary() {
		return this.theBasicMonthlySalary + this.theBasicMonthlySalary*0.4;
	}
	
}

