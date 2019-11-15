package Tuan8.KeThuaDaHinhNew;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QuanLySoftwareHouseTest {
	
	public SoftwareHouse sh = new SoftwareHouse("test");
	public Employee a = new Programmer(123456,"Le Chuong",6000,"java");
	public Employee b = new Administrator(456789,"Nguyen Duy",7000,"Ruby");
	public Employee c = new ProjectLeader(741258,"Doan Lan",6000,"dotNET");
	
	@Test
	public void testAddEmployeeSuccess() {
		assertEquals(true,sh.addEmployee(a));
		assertEquals(true,sh.addEmployee(b));
		assertEquals(true,sh.addEmployee(c));
	}
	
	@Test
	public void testAddEmployeeFail() {
		assertEquals(true,sh.addEmployee(a));
		assertEquals(true,sh.addEmployee(b));
		assertEquals(true,sh.addEmployee(c));
		assertEquals(true,sh.addEmployee(c));
	}
	
	@Test
	public void testGetMonthlySalaryBillFail() {
		sh.addEmployee(a);
		sh.addEmployee(b);
		sh.addEmployee(c);
		assertEquals(19000,sh.getMonthlySalaryBill());
	}
	
	@Test
	public void testGetMonthlySalaryBillSuccess() {
		sh.addEmployee(a);
		sh.addEmployee(b);
		sh.addEmployee(c);
		double k = 6000+6000*0.2+7000+7000*0.4+6000+6000*0.2;
		assertEquals(k,sh.getMonthlySalaryBill());
	}
	
	@Test
	public void testSortByNameFail() {
		sh.addEmployee(c);
		sh.addEmployee(a);
		sh.addEmployee(b);
		sh.sortAllStaffByName();
		assertEquals("Doan Lan",sh.getList().get(2).getTheName());
	}
	
	@Test
	public void testSortByNameSuccess() {
		sh.addEmployee(c);
		sh.addEmployee(a);
		sh.addEmployee(b);
		sh.sortAllStaffByName();
		assertEquals("Nguyen Duy",sh.getList().get(2).getTheName());
	}
}
