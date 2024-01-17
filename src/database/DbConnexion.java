package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import utils.Constants;
import utils.Utils;

public class DbConnexion {
        //khai báo dối tượng staic kết nối
	private static Connection connection = null;

	public DbConnexion() {
	}

	static {
		try {
                    //tải trình điều khiển JDBC
			Class.forName(Constants.JDBC_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			Utils.getLogger(Level.SEVERE, " !");
		}
	}
        
        //phương thức này kết nối đến csdl
	public static Connection getConnection() throws SQLException {
		//I added resources folder on my project built path, it's work on eclipse and on jar
		String jarPath = "jdbc:sqlite::resource:" + Constants.DB_PATH; 
		System.out.println(jarPath);
		connection = DriverManager.getConnection(jarPath);
		Utils.getLogger(Level.INFO, "Kết nối với cơ sở dữ liệu thành công !");

		return connection;
	}
        // các hàm đóng kết nối
	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}
	public static void closePrepaerdStatement(PreparedStatement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

	private static boolean isDbConnected(Connection con) {
		// final String CHECK_SQL_QUERY = "SELECT 1";
		try {
			if (!con.isClosed() || con != null) {
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}

	/*
	 * public void getConnection() throws SQLException{ try {
	 * 
	 * Class.forName("org.sqlite.JDBC"); connection =
	 * DriverManager.getConnection("jdbc:sqlite:" + DBPath); statement =
	 * connection.createStatement();
	 * 
	 * Utils.getLogger(Level.INFO, "Connexion a " + DBPath +
	 * " effectuer avec succès");
	 * 
	 * } catch (ClassNotFoundException notFoundException) {
	 * notFoundException.printStackTrace(); Utils.getLogger(Level.SEVERE,
	 * "Erreur de connexion à la base de donnée "); } catch (SQLException
	 * sqlException) { sqlException.printStackTrace(); Utils.getLogger(Level.SEVERE,
	 * "Erreur de connexion à la base de donnée "); } }
	 * 
	 * public void close() { try { connection.close(); statement.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } }
	 * 
	 */

}
