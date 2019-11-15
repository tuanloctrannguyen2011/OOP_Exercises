package HoaDonTienDien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
/**
 * 
 * @author Trần Nguyễn Tuấn Lộc
 *
 */
public abstract class Hoadon {

	protected long sohd;
	protected LocalDate ngayHoadon;
	protected String tenKhachhang;
	protected int soKwTieuthu;
	/**
	 * 
	 * @param sohd: số hóa đơn là số nguyên không trùng nhau
	 * @param ngayHoadon: ngày hóa đơn là ngày xuất hóa đơn
	 * @param tenKhachhang
	 * @param soKwTieuthu: số Kw trong tháng người tiêu dùng tiêu thụ
	 */
	public Hoadon(long sohd, LocalDate ngayHoadon, String tenKhachhang, int soKwTieuthu) {
		this.sohd = sohd;
		this.ngayHoadon = ngayHoadon;
		this.tenKhachhang = tenKhachhang;
		this.soKwTieuthu = soKwTieuthu;
	}
/**
 * 
 * @param sohd: số hóa đơn là số nguyên không trùng nhau
 */
	public Hoadon(long sohd) {
		this.sohd = sohd;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtfmt=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%-20d %-14s %-45s %-8d", sohd, dtfmt.format(ngayHoadon), tenKhachhang, soKwTieuthu);
	}

	public long getSohd() {
		return sohd;
	}

	public LocalDate getNgayHoadon() {
		return ngayHoadon;
	}

	public String getTenKhachhang() {
		return tenKhachhang;
	}

	public int getSoKwTieuthu() {
		return soKwTieuthu;
	}

	public void setSohd(long sohd) {
		this.sohd = sohd;
	}

	public void setNgayHoadon(LocalDate ngayHoadon) {
		this.ngayHoadon = ngayHoadon;
	}

	public void setTenKhachhang(String tenKhachhang) {
		this.tenKhachhang = tenKhachhang;
	}

	public void setSoKwTieuthu(int soKwTieuthu) throws InputMismatchException {
		if(soKwTieuthu > 0) {
			this.soKwTieuthu = soKwTieuthu;
		}else {
			throw new InputMismatchException("Số Kw tiêu thụ không được phép nhỏ hơn 0");
		}
	}
	
	public abstract double getTiendien();
	
}
