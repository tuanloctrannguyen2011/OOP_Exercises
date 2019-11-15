package HoaDonTienDien;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Locale;

public class HoadonKinhdoanh extends Hoadon {

	private int soKwGiothapdiem;
	private int soKwGiocaodiem;
	/**
	 * 
	 * @param sohd: số hóa đơn là số nguyên không trùng nhau
	 * @param ngayHoadon: ngày hóa đơn là ngày xuất hóa đơn
	 * @param tenKhachhang
	 * @param soKwTieuthu: số Kw trong tháng người tiêu dùng tiêu thụ
	 * @param soKwGiothapdiem: số Kw trong tháng người tiêu dùng tiêu thụ trong giờ thấp điểm
	 * @param soKwGiocaodiem: số Kw trong tháng người tiêu dùng tiêu thụ trong giờ cao điểm
	 */
	public HoadonKinhdoanh(long sohd, LocalDate ngayHoadon, String tenKhachhang, int soKwTieuthu, int soKwGiothapdiem, int soKwGiocaodiem) {
		super(sohd, ngayHoadon, tenKhachhang, soKwTieuthu);
		this.soKwGiothapdiem = soKwGiothapdiem;
		this.soKwGiocaodiem = soKwGiocaodiem;
	}
	/**
	 * 
	 * @param sohd: số hóa đơn là số nguyên không trùng nhau
	 */
	public HoadonKinhdoanh(long sohd) {
		super(sohd);
	}

	@Override
	public double getTiendien() {
		return this.soKwGiocaodiem*3500 + this.soKwGiothapdiem*1000 + (this.soKwTieuthu - (this.soKwGiocaodiem + this.soKwGiothapdiem))*2000;
	}
	
	@Override
	public String toString() {
		NumberFormat nfmt = NumberFormat.getCurrencyInstance(new Locale("vn","VN"));
		return super.toString() + String.format("%-8d %-8d %-10s", soKwGiothapdiem, soKwGiocaodiem, nfmt.format(getTiendien()));
	}

	public int getSoKwGiothapdiem() {
		return soKwGiothapdiem;
	}

	public int getSoKwGiocaodiem() {
		return soKwGiocaodiem;
	}

	public void setSoKwGiothapdiem(int soKwGiothapdiem) throws InputMismatchException {
		if(soKwGiothapdiem > 0) {
			this.soKwGiothapdiem = soKwGiothapdiem;
		}else {
			throw new InputMismatchException("Số Kw giờ thấp điểm không được phép nhỏ hơn 0");
		}
	}

	public void setSoKwGiocaodiem(int soKwGiocaodiem) throws InputMismatchException {
		if(soKwGiocaodiem > 0) {
			this.soKwGiocaodiem = soKwGiocaodiem;
		}else {
			throw new InputMismatchException("Số Kw giờ cao điểm không được phép nhỏ hơn 0");
		}
	}
	
	public boolean kiemtraDulieu(int soKwGiocaodiem, int soKwGiothapdiem, int soKwTieuthu) {
		if(soKwTieuthu > soKwGiothapdiem + soKwGiocaodiem) 
			return true;
		return false;
	}
	
}
