package portfolio;
//database 환경설정

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
	public static Connection info() throws Exception{
		String db_driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://umj7-003.cafe24.com/primewom137";
		//String db_url = "jdbc:mysql://localhost/primewom137"; 배포할때는 로컬호스트를 오픈하자
		String db_user = "primewom137";
		String db_pass = "@acts32dim";
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url, db_user, db_pass); //sql.Connection
		return con;
	}
}
