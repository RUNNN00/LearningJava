package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {

		//insertDatas();
		//updateDatas();
		transactionDatas();
	}

	public static void insertDatas() {

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

	public static void updateDatas() {
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE DepartmentId = ? "
					+ "LIMIT '1'");
			
			pst.setDouble(1, 200.00);
			pst.setInt(2, 2);
			
			int rowsAffected = pst.executeUpdate();
			System.out.println("Done rows affected " + rowsAffected);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}
	}

	public static void deleteDatas() {
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE Id = ?");
			
			pst.setInt(1, 2);
			
			int rowsAffected = pst.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}
	}
	
	public static void transactionDatas() {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false); // comando para não confirmar as operações automaticamente
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			
			// Simulação de erro entre duas operações com o banco de dados
			//int x = 1;
			//if (x < 2) throw new SQLException("Fake error");
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			conn.commit(); // comando para confirmar as operações feitas até esta linha
			
			System.out.println("Rows1 affected: " + rows1);
			System.out.println("Rows2 affected: " + rows2);
			
		}
		catch (SQLException e) {
			try {
				conn.rollback(); // comando para desfazer as operações caso tenha ocorrido alguma exceção
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			}
			catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}