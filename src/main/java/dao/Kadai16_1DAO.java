package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Kadai16;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class Kadai16_1DAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static int registerKadai(Kadai16 kadai16) {
		String sql = "INSERT INTO kadai16 VALUES(?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		String salt = GenerateSalt.getSalt(32);
		
		String hashedPw = GenerateHashedPw.getSafetyPassword(kadai16.getPass(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, kadai16.getName());
			pstmt.setInt(2,kadai16.getAge());
			pstmt.setString(3, kadai16.getGender());
			pstmt.setInt(4,kadai16.getTel());
			pstmt.setString(5, kadai16.getMail());
			pstmt.setString(6, hashedPw);
			pstmt.setString(7, salt);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	public static List<Kadai16> selectAllKadai() {
		
		List<Kadai16> result = new ArrayList<>();

		String sql = "SELECT * FROM kadai16";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					int tel = rs.getInt("tel");
					String mail = rs.getString("mail");

					Kadai16 kadai16 = new Kadai16(name,age,gender,tel,mail,null,null,null);
					
					result.add(kadai16);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return result;
	}
	public static int deleteKadai(String mail) {
		String sql = "DELETE FROM kadai16 WHERE mail=?";
		int result = 0;

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public static Kadai16 selectkadai(String mail){
		Kadai16 result = null;
		
		String sql = "SELECT * FROM Kadai16 WHERE mail = ?";
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setString(1, mail);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					int tel = rs.getInt("tel");
					String email = rs.getString("mail");
					
					result = new Kadai16(name, age, gender, tel, email, null,null,null);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM kadai16 WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Kadai16 login(String mail, String hashedPw) {
		String sql = "SELECT * FROM kadai16 WHERE mail = ? AND password = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					int tel = rs.getInt("tel");
					String email = rs.getString("mail");
					
					return new Kadai16(name, age, gender, tel, email, null,null,null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
