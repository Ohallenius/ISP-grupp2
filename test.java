import java.sql.*;
public class Test {

	public static void main(String[] args) {
		
			
			//hämta MSSQL drivern//
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			// server conf //
			
			String server = "192.168.1.102";
			int port = 1433;
			String user = "sa";
			String password = "kentakuk";
			String database = "T3skola";
			
			//skapar data connection//
		
			String jdbcUrl = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+password+";databaseName="+database+"";
			Connection con = DriverManager.getConnection(jdbcUrl);
			if (con == null){
				System.out.println("# - Connection failed: ");
			}
				if(con != null){
					System.out.println("# - Connection established");
				}
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from Student");
			System.out.println("# - Query Executed");
			
			while (rs.next()) {
		        String pnr = rs.getString("pnr");
		        System.out.println(pnr + "\n");
		        String namn = rs.getString("namn");
		        System.out.println(namn + "\n");
			}
			}catch(Exception e) {
			System.out.println("Error: connection failed:" +e);
		}
		}
		
			
		

}
