package HoaDonTienDien;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class HoadonHogiadinh extends Hoadon {
/**
 * 
 * @param sohd: số hóa đơn là số nguyên không trùng nhau
 * @param ngayHoadon: ngày hóa đơn là ngày xuất hóa đơn
 * @param tenKhachhang
 * @param soKwTieuthu: số Kw trong tháng người tiêu dùng tiêu thụ
 */
	public HoadonHogiadinh(long sohd, LocalDate ngayHoadon, String tenKhachhang, int soKwTieuthu) {
		super(sohd, ngayHoadon, tenKhachhang, soKwTieuthu);
	}
/**
 * 
 * @param sohd: số hóa đơn là số nguyên không trùng nhau
 */
	public HoadonHogiadinh(long sohd) {
		super(sohd);
	}

	@Override
	public double getTiendien() {
		int x = soKwTieuthu;
		if(x > 400) {
			return 100*1500 + 100*1700 + 100*2200 + 100*2500 + (x - 400)*3000;
		}else if(x > 300 && x < 401) {
			return 100*1500 + 100*1700 + 100*2200 + (x - 300)*2500;
		}else if(x > 200 && x < 301) {
			return 100*1500 + 100*1700 + (x - 200)*2200;
		}else if(x > 100 && x < 201) {
			return 100*1500 + (x - 100)*1700;
		}else {
			return x*1500;
		}
	}

	@Override
	public String toString() {
		NumberFormat nfmt = NumberFormat.getCurrencyInstance(new Locale("vn","VN"));
		return super.toString() + String.format("%-10s", nfmt.format(getTiendien()));
	}
	
}
