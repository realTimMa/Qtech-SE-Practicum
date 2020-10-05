package cn.qdlgdx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.qdlgdx.util.DBUtil;

/**
 * 
 * @author Tim Ma
 *
 */
public class LoginDao {
	public static int loginCheck(String usrId, String usrName, String usrPwd, String usrLvl) {
		int flag = -1;
		if (usrLvl == "管理员") {
			try {
				DBUtil db = new DBUtil();
				Connection conn = db.getConnection();
				String sql = "select count(*) from Admtable where Admname = ? and Admpass = ?;";
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, usrName);
				pstmt.setString(2, usrPwd);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					flag = rs.getInt(1);
				}
				db.closeAll();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		} else if (usrLvl == "秘书") {
			try {
				DBUtil db = new DBUtil();
				Connection conn = db.getConnection();
				String sql = "select count(*) from Sectable where Secname = ? and Secpass = ?;";
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, usrName);
				pstmt.setString(2, usrPwd);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					flag = rs.getInt(1);
				}
				db.closeAll();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		} else if (usrLvl == "员工") {
			try {
				DBUtil db = new DBUtil();
				Connection conn = db.getConnection();
				String sql = "select count(*) from Usertable where UserID = ? and Username = ? and Userpass = ?;";
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, usrId);
				pstmt.setString(2, usrName);
				pstmt.setString(3, usrPwd);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					flag = rs.getInt(1);
				}
				db.closeAll();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return flag;
	}
}
