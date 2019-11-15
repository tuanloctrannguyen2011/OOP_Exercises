package HoaDonTienDien;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;

class TestcaseHoadon {

	DanhsachHoadon testcaseds = new DanhsachHoadon();
	Hoadon a = new HoadonHogiadinh(135, LocalDate.of(2017, 2, 3), "Nguyễn Thị Kim Ngân", 257);
	Hoadon b = new HoadonHogiadinh(246, LocalDate.of(2017, 2, 5), "Lê Hoàng Nguyên Chương", 403);
	Hoadon c = new HoadonKinhdoanh(369, LocalDate.of(2017, 5, 12), "Nguyễn Dương Ngọc Thảo", 2017, 1169, 696);

	@Test
	void testGetTiendienHogiadinhPassed() {
		assertEquals(445400,a.getTiendien());
	}
	
	@Test
	void testGetTiendienHogiadinhFailed() {
		assertEquals(445500,a.getTiendien());
	}
	
	@Test
	void testGetTiendienKinhdoanhPassed() {
		assertEquals(3909000,c.getTiendien());
	}
	
	@Test
	void testGetTiendienKinhdoanhFailed() {
		assertEquals(3989000,c.getTiendien());
	}
	
	@Test
	void testSetSoKwTieuThuPassed() {
		Throwable exception = assertThrows(InputMismatchException.class, ()->{c.setSoKwTieuthu(0);} );
	}

	@Test
	void testSetSoKwTieuThuFailed() {
		Throwable exception = assertThrows(InputMismatchException.class, ()->{c.setSoKwTieuthu(500);} );
	}
	
	@Test
	void testSetSoKwGioCaoDiemPassed() {
		Throwable exception = assertThrows(InputMismatchException.class, ()->{((HoadonKinhdoanh)c).setSoKwGiocaodiem(0);} );
	}
	
	@Test
	void testSetSoKwGioCaoDiemFailed() {
		Throwable exception = assertThrows(InputMismatchException.class, ()->{((HoadonKinhdoanh)c).setSoKwGiocaodiem(500);} );
	}
	
	@Test
	void testSetSoKwGioThapDiemPassed() {
		Throwable exception = assertThrows(InputMismatchException.class, ()->{((HoadonKinhdoanh)c).setSoKwGiothapdiem(0);} );
	}
	
	@Test
	void testSetSoKwGioThapDiemFailed() {
		Throwable exception = assertThrows(InputMismatchException.class, ()->{((HoadonKinhdoanh)c).setSoKwGiothapdiem(500);} );
	}
	
	@Test
	void testThemHoaDonPassed() {
		assertEquals(true, testcaseds.themHD(a));
		assertEquals(true, testcaseds.themHD(b));
		assertEquals(true, testcaseds.themHD(c));
	}
	
	@Test
	void testThemHoaDonFailed() {
		assertEquals(true, testcaseds.themHD(a));
		assertEquals(true, testcaseds.themHD(b));
		assertEquals(true, testcaseds.themHD(c));
		assertEquals(true, testcaseds.themHD(a));
	}
	
	@Test
	void testGetTongTienPassed() {
		testcaseds.themHD(a);
		testcaseds.themHD(b);
		testcaseds.themHD(c);
		double expectation =  445400 + 799000 + 1169000 + 304000 + 2436000;
		assertEquals(expectation,testcaseds.getTongtien());
	}
	
	@Test
	void testGetTongTienFailed() {
		testcaseds.themHD(a);
		testcaseds.themHD(b);
		testcaseds.themHD(c);
		double expectation =  445500 + 799100 + 1179000 + 314000 + 2496000;
		assertEquals(expectation,testcaseds.getTongtien());
	}
	
	@Test
	void testSapXepPassed() {
		testcaseds.themHD(a);
		testcaseds.themHD(b);
		testcaseds.themHD(c);
		testcaseds.sapxep();
		assertEquals("Nguyễn Thị Kim Ngân",testcaseds.getDsHoadon().get(0).getTenKhachhang());
	}
	
	@Test
	void testSapXepFailed() {
		testcaseds.themHD(a);
		testcaseds.themHD(b);
		testcaseds.themHD(c);
		testcaseds.sapxep();
		assertEquals("Nguyễn Dương Ngọc Thảo",testcaseds.getDsHoadon().get(0).getTenKhachhang());
	}

}
