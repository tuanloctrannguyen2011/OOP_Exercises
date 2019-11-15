package Tuan8.KeThuaDaHinhNew;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class QuanLySoftwareHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int option = 0,no;
		String name,lang,dept;
		double basic;
		
		System.out.println("Insert your Software Company's Name: ");
		String cName = sc.nextLine();		
		SoftwareHouse Company = new SoftwareHouse(cName);
		System.out.println("---------------Software House " + cName + "----------------");

		while(option>=0 && option<8) {
			
			System.out.println("MENU:\n===============================================");
			System.out.println("1:Add new programmer.");
			System.out.println("2:Add new project leader.");
			System.out.println("3:Add new administrator.");
			System.out.println("4:Display all staff.");
			System.out.println("5:Get the salary bill.");
			System.out.println("6:Display list of programmers.");
			System.out.println("7:Update department for Admin.");
			System.out.println("====================================================");
			System.out.print("Insert the number you want to execute: "); option = sc.nextInt();
			
			switch(option) {
			
			case 1: sc.nextLine();
					System.out.print("Insert Name: "); name = sc.nextLine();
					System.out.print("Insert Payroll Number: "); no = sc.nextInt();
					System.out.print("Insert Basic Monthly Salary: "); basic = sc.nextDouble();
					sc.nextLine();
					System.out.print("Insert Language: "); lang = sc.nextLine();
					Company.addEmployee(new Programmer(no,name,basic,lang));
					break;
			
			case 2: sc.nextLine();
					System.out.print("Insert Name: "); name = sc.nextLine();
					System.out.print("Insert Payroll Number: "); no = sc.nextInt();
					System.out.print("Insert Basic Monthly Salary: "); basic = sc.nextDouble();
					sc.nextLine();
					System.out.print("Insert Language: "); lang = sc.nextLine();
					Company.addEmployee(new ProjectLeader(no,name,basic,lang));
					break;
			
			case 3: sc.nextLine();
					System.out.print("Insert Name: "); name = sc.nextLine();
					System.out.print("Insert Payroll Number: "); no = sc.nextInt();
					System.out.print("Insert Basic Monthly Salary: "); basic = sc.nextDouble();
					sc.nextLine();
					System.out.print("Insert Department's Name: "); dept = sc.nextLine();
					Company.addEmployee(new Administrator(no,name,basic,dept));
					break;
			
			case 4: Company.sortAllStaffByName();
					Company.displayAllStaff(); 
					break;
			
			case 5: Locale VN = new Locale("vn","vn");
					NumberFormat nf = NumberFormat.getCurrencyInstance(VN);
					System.out.println(cName + " total Salary bill: " + nf.format(Company.getMonthlySalaryBill()));
					break;
			
			case 6: Company.sortAllStaffByName();
					Company.DisplayListProgrammers();; 
					break;
			
			case 7: sc.nextLine();
					System.out.print("Insert the Payroll Number of Administrator: "); no = sc.nextInt();
					sc.nextLine();
					System.out.print("Insert new Department's Name: "); dept = sc.nextLine();
					if(Company.updateDepartmentForAdmin(no, dept))
						System.out.println("Update Success!");
					else
						System.out.println("Invalid Payroll Number!");
					break;
			
			default: break;
			}
		}
		sc.close();
	}
}
