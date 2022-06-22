package businessLogics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CSDL {

	
	
	private static JdbcTemplate jdbc;
	
	public static JdbcTemplate getJDBC() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/qlbanhoa?useUnicode=true&characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword(""); 
		jdbc=new JdbcTemplate(dataSource);
		return jdbc;
	}
	
}
