package cn.qdlgdx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.qdlgdx.util.Config;

/**
 * 
 * @author Tim Ma
 *
 */
public class DBUtil {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	/**
	 * �õ����ݿ�����
	 */
	public Connection getConnection()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		// ͨ��Config��ȡMysql���ݿ�������Ϣ
		String driver = Config.getValue("driver");
		String url = Config.getValue("url");
		String user = Config.getValue("username");
		String pwd = Config.getValue("password");
		try {
			// ָ����������
			Class.forName(driver);
			// �������ݿ�����
			conn = DriverManager.getConnection(url, user, pwd);
			return conn;
		} catch (Exception e) {
			// ������ӹ��̳����쳣���׳��쳣��Ϣ
			throw new SQLException("�������������ʧ�ܣ�");
		}
	}

	/**
	 * �ͷ���Դ
	 */
	public static void closeAll() {
		// ���rs���գ��ر�rs
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// ���pstmt���գ��ر�pstmt
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// ���conn���գ��ر�conn
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ִ��SQL��䣬���Խ��в�ѯ
	 */
	public ResultSet executeQuery(String preparedSql, String[] param) {
		// ����SQL,ִ��SQL
		try {
			// �õ�PreparedStatement����
			conn = getConnection();
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					// ΪԤ����sql���ò���
					pstmt.setString(i + 1, param[i]);
				}
			}
			// ִ��SQL���
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// ����SQLException�쳣
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * ִ��SQL��䣬���Խ�������ɾ���ĵĲ���������ִ�в�ѯ
	 */
	public int executeUpdate(String preparedSql, String[] param) {
		int num = 0;
		// ����SQL,ִ��SQL
		try {
			// �õ�PreparedStatement����
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					// ΪԤ����sql���ò���
					pstmt.setString(i + 1, param[i]);
				}
			}
			// ִ��SQL���
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// ����SQLException�쳣
			e.printStackTrace();
		}
		return num;
	}
}
