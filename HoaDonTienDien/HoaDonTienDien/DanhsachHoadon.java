package HoaDonTienDien;

import java.util.*;

public class DanhsachHoadon {

	private List<Hoadon> dsHoadon;
	
	public DanhsachHoadon() {
		dsHoadon = new ArrayList<Hoadon>();
	}
	
	public List<Hoadon> getDsHoadon() {
		return dsHoadon;
	}
/**
 * 
 * @param hd: hóa đơn cần thêm vào
 * @return false nếu trùng mã, true nếu thêm được 1 hóa đơn
 */
	public boolean themHD(Hoadon hd) {
		for(Hoadon hoadon: dsHoadon)
			if(hoadon.getSohd() == hd.getSohd())
				return false;
		this.dsHoadon.add(hd);
		return true;
	}
/**
 * xuất danh sách hóa đơn nếu hóa đơn thuộc HoadonHogiadinh thì xuất theo định dạng HoadonHogiadinh, nếu hóa đơn thuộc HoadonKinhdoanh thì xuất theo định dạng HoadonKinhdoanh	
 */
	public void xuatDsHoadon() {
		for(Hoadon hoadon: dsHoadon)
			if(hoadon instanceof HoadonHogiadinh) {
				System.out.printf("%-20s %-14s %-45s %-8s %-10s\n", "Số hóa đơn","Ngày Hóa Đơn","Tên Khách Hàng","Số Kw Tiêu Thụ","Thành Tiền");
				System.out.println(hoadon);
			}else if(hoadon instanceof HoadonKinhdoanh) {
				System.out.printf("%-20s %-14s %-45s %-8s %-8s %-8s %-10s\n", "Số hóa đơn","Ngày Hóa Đơn","Tên Khách Hàng","Số Kw Tiêu Thụ","Số Kw Giờ Thấp Điểm","Số Kw Giờ Cao Điểm","Thành Tiền");
				System.out.println(hoadon);
			}
	}
/**
 * 	
 * @return tổng thành tiền của tất cả các hóa đơn
 */
	public double getTongtien() {
		double total = 0;
		for(Hoadon hoadon: dsHoadon)
			total += hoadon.getTiendien();
		return total;
	}
/**
 * sắp xếp danh sách hóa đơn theo ngày hóa đơn	
 */
	public void sapxep() {
		this.dsHoadon.sort(Comparator.comparing(Hoadon::getNgayHoadon));
	}
	
}
