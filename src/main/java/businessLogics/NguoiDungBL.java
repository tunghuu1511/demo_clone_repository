package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javaBeans.NguoiDung;

public class NguoiDungBL {

	private static JdbcTemplate jdbc=CSDL.getJDBC();
	private static class AnhXa implements RowMapper<NguoiDung>{
		@Override
		public NguoiDung mapRow(ResultSet rs, int arg1) throws SQLException {
			NguoiDung nd= new NguoiDung();
			nd.setiMaKH(rs.getInt("Makh"));
			nd.setStrTenDangNhap(rs.getString("TenDangNhap"));
			nd.setStrMatKhau(rs.getString("MatKhau"));
			nd.setStrQuyenTruyCap(rs.getString("QuyenTruyCap"));
			nd.setStrHoTen(rs.getString("HoTen"));
			nd.setStrDiaChi(rs.getString("DiaChi"));
			nd.setStrSDT(rs.getString("DienThoai"));
			nd.setStrEmail(rs.getString("Email"));	
			return nd;
		}	
	}
	
	public static NguoiDung DangNhap(String strTenDangNhap,String strMatKhau) {
		String strCauLenh="SELECT * FROM `khachhang` WHERE `TenDangNhap`='"+strTenDangNhap+"' AND `MatKhau`='"+strMatKhau+"'";
		if (jdbc.query(strCauLenh, new AnhXa()).size()==0) {
			return null;
		}
		return jdbc.query(strCauLenh,new AnhXa()).get(0);
	}
	
	public static int DangKy(NguoiDung nd)
	{
		String tendn,matkhau,hoten,diachi,sdt,email,quyentruycap;
		tendn=nd.getStrTenDangNhap();
		matkhau=nd.getStrMatKhau();
		hoten=nd.getStrHoTen();
		diachi=nd.getStrDiaChi();
		sdt=nd.getStrSDT();
		email=nd.getStrEmail();
		quyentruycap=nd.getStrQuyenTruyCap();
		String strCauLenh="INSERT INTO khachhang(`TenDangNhap`,`MatKhau`,`HoTen`,`DiaChi`,`DienThoai`,`Email`,`QuyenTruyCap`) VALUES ('"+tendn+"','"+matkhau+"','"
				+hoten+ "','"+diachi+"','"+sdt+"','"+email+"','"+quyentruycap+"')";
		return jdbc.update(strCauLenh);
	}
	
	public static int ThanhToan(NguoiDung nd , GioHang gh )
	{
		String strCauLenh1="INSERT INTO hoadon (`MaKhachHang`,`NgayDatHang`,`TongThanhToan`,`TrangThai`) VALUES('"+nd.getiMaKH()+
				"',(SELECT CURRENT_DATE()),'"+gh.TongThanhTien()+"','1')";
		if(jdbc.update(strCauLenh1)==1)
		{
			int iMaHoaDon =  jdbc.queryForObject("SELECT ID FROM hoadon ORDER by ID DESC LIMIT 1", Integer.class);
			gh.DanhSachDaMua().forEach(k->jdbc.update("INSERT INTO `chitiethoadon` (`MaHoaDon`, `MaHoa`, `SoLuong`, `DonGia`, `ThanhTien`) "
					+ "VALUES ('"+iMaHoaDon+"', '"+k.getiMaHoa()+"', '"+k.getiSoLuong()+"', '"+k.getlDonGia()+"', '"+k.ThanhTien()+"')"));
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
//		System.out.print( DangNhap("phuong", "phuong").getStrHoTen() );
//		NguoiDung nd=new NguoiDung();
//		nd.setStrDiaChi("dsdsffggh");
//		nd.setiMaKH(3);
//		nd.setStrEmail(";lkjhgghghj");
//		nd.setStrHoTen("ác");
//		nd.setStrMatKhau("2");
//		nd.setStrSDT("2");
//		nd.setStrTenDangNhap("4");
//		nd.setStrQuyenTruyCap("KhachHang");
//		GioHang gHang = new GioHang();
//		System.out.print(ThanhToan(nd, gHang));
//		System.out.print( DangKy(nd));
//		System.out.print( DangNhap("4", "2").getStrHoTen() );
	}
}
