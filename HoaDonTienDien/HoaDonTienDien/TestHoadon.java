package HoaDonTienDien;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class TestHoadon {

	public static void main(String[] args) {
		Scanner Nhap=new Scanner(System.in);
		DanhsachHoadon hd=new DanhsachHoadon();
		
		while(true)
		{
			System.out.println("1. Thêm một hóa đơn hộ gia đình");
			System.out.println("2. Thêm một hóa đơn kinh doanh");
			System.out.println("3. Xuất danh sách các hóa đơn");
			System.out.println("4. Tổng số tiền thu được của tất cả các hóa đơn");
			System.out.println("5. Sắp xếp các hóa đơn theo ngày");
			System.out.println("6. Thoát khỏi chương trình");
			System.out.print("Nhập vào lựa chọn bạn muốn:");
			int luachon=Nhap.nextInt();
			
			switch (luachon) {
			case 1:
				System.out.print("Số HĐ:");
				long SoHD=Nhap.nextLong();
				
				System.out.print("Ngày hóa đơn:");
				int NgayHoaDon=Nhap.nextInt();

				System.out.print("Tháng hóa đơn:");
				int ThangHoaDon=Nhap.nextInt();
				
				System.out.print("Năm hóa đơn:");
				int NamHoaDon=Nhap.nextInt();
				
				System.out.print("Tên khách hàng:");
				Nhap.nextLine();
				String TenKhachHang=Nhap.nextLine();
				
				System.out.print("Số Kw tiêu thụ:");
				int SoKwTieuthu=Nhap.nextInt();
				
				LocalDate dt= LocalDate.of(NamHoaDon, ThangHoaDon, NgayHoaDon);
							
				hd.themHD(new HoadonHogiadinh(SoHD, dt, TenKhachHang, SoKwTieuthu));
				break;
			case 2:
				System.out.print("Số HĐ:");
				long SoHD1=Nhap.nextLong();
				
				System.out.print("Ngày hóa đơn:");
				int NgayHoaDon1=Nhap.nextInt();

				System.out.print("Tháng hóa đơn:");
				int ThangHoaDon1=Nhap.nextInt();
				
				System.out.print("Năm hóa đơn:");
				int NamHoaDon1=Nhap.nextInt();
				
				System.out.print("Tên khách hàng:");
				Nhap.nextLine();
				String TenKhachHang1=Nhap.nextLine();
				
				System.out.print("Số Kw tiêu thụ:");
				int SoKwTieuthu1=Nhap.nextInt();
				
				System.out.print("Số Kw Giờ thấp điểm:");
				int SoKwGiothapdiem=Nhap.nextInt();
				
				System.out.print("Số Kw Giờ cao điểm:");
				int SoKwGiocaodiem=Nhap.nextInt();
				
				LocalDate dt1= LocalDate.of(NamHoaDon1, ThangHoaDon1, NgayHoaDon1);
				
				hd.themHD(new HoadonKinhdoanh(SoHD1, dt1, TenKhachHang1, SoKwTieuthu1, SoKwGiothapdiem, SoKwGiocaodiem));
				break;
			case 3:
				hd.xuatDsHoadon();
			case 4:
				NumberFormat nfmt = NumberFormat.getCurrencyInstance(new Locale("vn","VN"));
				System.out.println("Tổng số tiền của tất cả hóa đơn là: " + nfmt.format(hd.getTongtien()));
				break;
			case 5:
				hd.sapxep();
				break;
			case 6:
				return;
			default:
				break;
			}
		}

	}

}
