package Tuan8.KeThuaDaHinhNew;

public class ProjectLeader extends Programmer {
	
	public ProjectLeader(int number, String name, double basic, String lang) {
		super(number,name,basic,lang);
	}
	
	@Override
	public double getMonthlySalary() {
		if(this.theLanguage.equalsIgnoreCase("java"))
			return (this.theBasicMonthlySalary + this.theBasicMonthlySalary*0.4);
		else
			return (this.theBasicMonthlySalary + this.theBasicMonthlySalary*0.2);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
