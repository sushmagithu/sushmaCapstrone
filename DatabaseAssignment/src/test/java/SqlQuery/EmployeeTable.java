package SqlQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeTable {

	static Connection con = null;
	private static Statement stmt;
	public static String DB_URL = "jdbc:mysql://127.0.0.1:3306/mydb";
	public static String DB_USER = "root";
	public static String DB_PASSWORD = "root";

	@BeforeTest
	public void setUp() throws Exception {
		try {
			String dbClass = "com.mysql.cj.jdbc.Driver";
			Class.forName(dbClass).newInstance();
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		try {
			String query = "SELECT EmployeeId,EmployeeName,EmployeeAge,MAX(EmployeeSalary) AS EmployeeSalary FROM employee  WHERE EmployeeSalary <> (SELECT MAX(EmployeeSalary)FROM employee)";
			
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				System.out.print(res.getString(1));
				System.out.print(" " + res.getString(2));
				System.out.print(" " + res.getString(3));
				System.out.println(" " + res.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		if (con != null) {
			con.close();
		}
	}

}
