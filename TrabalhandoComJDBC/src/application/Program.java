package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		insertDatasIntoDatabase();
	}

	public static void insertDatasIntoDatabase() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {

			conn = DB.getConnection();
			pst = conn.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) " + "VALUES " + "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, "Carlinhos");
			pst.setString(2, "Carlinhos@gamil.com");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			pst.setDate(3,  new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			pst.setDouble(4, 3000.00);
			pst.setInt(5, 4);
			
			int rowsAffected = pst.executeUpdate();
			
			if (rowsAffected > 0) {
				rs = pst.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Id = " + id);
				}
			}
			else {
				System.out.println("No row affected!");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
			DB.closeConnection();
		}

	}
}