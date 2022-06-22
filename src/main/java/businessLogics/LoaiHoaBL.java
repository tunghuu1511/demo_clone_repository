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
import javaBeans.LoaiHoa;

public class LoaiHoaBL {
	private static JdbcTemplate jdbc =CSDL.getJDBC();

	private static class AnhXa implements RowMapper<LoaiHoa> {

		@Override
		public LoaiHoa mapRow(ResultSet rs, int arg1) throws SQLException {
			LoaiHoa loaiHoa =new LoaiHoa();
			loaiHoa.setiMaLoai(rs.getInt("maloai"));
			loaiHoa.setStrTenLoai(rs.getString( "tenloai"));
			return loaiHoa;
		}
		
	}
	public static List<LoaiHoa> DocTatCa() throws SQLException {
		
		
		return jdbc.query("SELECT * FROM loaihoa", new AnhXa());
		
	}
}
