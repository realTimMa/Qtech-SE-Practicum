package cn.qdlgdx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.qdlgdx.util.DBUtil;

/**
 * 
 * @author Tim Ma
 *
 */
public class UserDao {

	public static int updateUsrPwd(String userId, String userPwd) {
		try {
			DBUtil db = new DBUtil();
			Connection conn = db.getConnection();
			String sql = "UPDATE Usertable SET Userpass=? WHERE UserID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);
			pstmt.executeUpdate();
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	public static int updateTask(String userName, int taskId, String taskPfmc) {
		DBUtil db = new DBUtil();
		try {

			Connection conn = db.getConnection();
			String checkSql = "SELECT Principal FROM Tasktable WHERE TaskID=" + taskId;
			ResultSet rs = db.executeQuery(checkSql, null);
			while (rs.next()) {
				if (userName.equals(rs.getString("Principal"))) {
					String sql = "UPDATE Tasktable SET Performance=? WHERE TaskID=?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, taskPfmc);
					pstmt.setInt(2, taskId);
					pstmt.executeUpdate();
				} else {
					db.closeAll();
					return 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		db.closeAll();
		return 0;
	}

	public ArrayList<String[]> selectTsk(String taskId) {
		ArrayList<String[]> list = new ArrayList<String[]>();
		try {
			DBUtil db = new DBUtil();
			db.getConnection();
			String sql = "SELECT * FROM Tasktable WHERE TaskID=" + taskId;
			ResultSet rs = db.executeQuery(sql, null);
			while (rs.next()) {
				String[] tsk = new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
						rs.getString(20), rs.getString(21) };
				list.add(tsk);
			}
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

}
