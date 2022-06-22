package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javaBeans.Hoa;

public class HoaBL {
	private static JdbcTemplate jdbc =CSDL.getJDBC();
	private static class AnhXa implements RowMapper<Hoa> {

		@Override
		public Hoa mapRow(ResultSet rs, int arg1) throws SQLException {
			Hoa h=new Hoa();
			h.setiMaHoa(rs.getInt("mahoa"));
			h.setiMaLoai(rs.getInt("maloai"));
			h.setStrTenHoa(rs.getString("tenhoa"));
			h.setlDonGia(rs.getLong("dongia"));
			h.setStrHinh(rs.getString("hinh"));
			h.setStrMoTa(rs.getString("mota"));
			return h;
		}
		
	}
	
	public static Hoa DocTheoMaHoa(int iMaHoa) {
		String strCauLenh="select * from hoa where mahoa = '"+iMaHoa+"'";
		List<Hoa> DS=jdbc.query(strCauLenh, new AnhXa());
		return DS.get(0);
	}
	
	public static List<Hoa>LayTatCa() throws SQLException {
		return jdbc.query("SELECT * FROM hoa", new AnhXa());
	}
	
	public static List<Hoa>LayTeoLLoaiHoa(int iMaLoai) throws SQLException {
		return jdbc.query("select * from hoa where maloai="+iMaLoai, new AnhXa());
	}
	
	public static List<Hoa>LayTheoTenHoa(String strMaLoai) throws SQLException {
		String caulenh="SELECT * FROM hoa where tenhoa like '%"+strMaLoai+"%'";
		return jdbc.query(caulenh,new AnhXa());
	}
	
	public static int ThemHoa(Hoa h) throws SQLException {
		
		String caulenh="INSERT INTO `hoa`( `maloai`, `tenhoa`, `dongia`, `hinh`, `mota`) VALUES ("+h.getiMaLoai()+",'"+h.getStrTenHoa()+"',"+h.getlDonGia()+",'"+h.getStrHinh()+"','"+h.getStrMoTa()+"')";
		return jdbc.update(caulenh);
	}
	
	public static List<Hoa> TimKiemTheoTenHoa(String strTenHoa) {
		return jdbc.query("Select * from Hoa Where tenhoa like '%"+strTenHoa+"%'", new AnhXa());
	}
	
	public static int TongSoTrang(int iSoSPMoiTrang ) throws SQLException {
		int iPhanNguyen=LayTatCa().size()/iSoSPMoiTrang;
		int iPhanDu=( LayTatCa().size()%iSoSPMoiTrang ==0)?0:1;
		return iPhanNguyen+iPhanDu;
	}
	
	public static int TongSoTrang(int iSoSPMoiTrang ,int iMaLoai ) throws SQLException {
		int iPhanNguyen=LayTeoLLoaiHoa(iMaLoai).size()/iSoSPMoiTrang;
		int iPhanDu=( LayTeoLLoaiHoa(iMaLoai).size()%iSoSPMoiTrang ==0)?0:1;
		return iPhanNguyen+iPhanDu;
	}
	
	public static List<Hoa> PhanTrang(int iSoLuongSPMoiTrang , int iTrangHienTai ) throws SQLException {
		int iSPBatDau = ( iTrangHienTai-1 ) * iSoLuongSPMoiTrang;
		String 	strCauLenh="select * from hoa order by mahoa asc limit "+iSPBatDau +","+iSoLuongSPMoiTrang;
		return jdbc.query(strCauLenh, new AnhXa());
	}
	
	public static List<Hoa> PhanTrang(int iSoLuongSPMoiTrang , int iTrangHienTai , int iMaLoai ) throws SQLException {
		int iSPBatDau = ( iTrangHienTai-1 ) * iSoLuongSPMoiTrang;
		String 	strCauLenh="select * from hoa where maloai="+iMaLoai+" order by mahoa asc limit "+iSPBatDau +","+iSoLuongSPMoiTrang;
		return jdbc.query(strCauLenh, new AnhXa());
	}
	
	public static void main(String[] args) throws SQLException {
//		Hoa h=DocTheoMaHoa(1);
//		System.out.print(h.getStrTenHoa());
//		System.out.print();
	}
}
