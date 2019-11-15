package Tuan8.KeThuaDaHinhNew;

import java.text.NumberFormat;
import java.util.Locale;

public class Programmer extends  Employee {
	protected String theLanguage;
	
	public Programmer(int number, String name, double basic, String lang) {
		super(number,name,basic);
		this.theLanguage = lang;
	}
	
	public String getTheLanguage() {
		return theLanguage;
	}

	public void setTheLanguage(String theLanguage) {
		this.theLanguage = theLanguage;
	}

	public double getMonthlySalary() {
		if(this.theLanguage.equalsIgnoreCase("java"))
			return (this.theBasicMonthlySalary + this.theBasicMonthlySalary*0.2);
		else
			return this.theBasicMonthlySalary;
	}
	
	public String toString() {
		Locale VN = new Locale("vn","vn");
		NumberFormat nf = NumberFormat.getCurrencyInstance(VN);
		return String.format("%-15d %-30s %12s %20s", this.thePayrollNumber, this.theName, nf.format(getMonthlySalary()),this.theLanguage);
	}
	
}
