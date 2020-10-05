package cn.qdlgdx.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qdlgdx.model.Month;
import cn.qdlgdx.model.Principal;
import cn.qdlgdx.service.JxlService;
import cn.qdlgdx.util.DBUtil;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.sql.PreparedStatement;

/**
 * 
 * @author Tim Ma
 *
 */
public class AdminDao {

	public static String[] selectUsr(String userId) {
		String[] usr = null;
		try {
			DBUtil db = new DBUtil();
			db.getConnection();
			String sql = "SELECT * FROM Usertable WHERE UserID=" + userId;
			ResultSet rs = db.executeQuery(sql, null);
			while (rs.next()) {
				usr = new String[] { rs.getString(1), rs.getString(2), rs.getString(3) };
			}
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return usr;
	}

	

	public static int insertUsr(int userId, String userName, String userPwd) {
		try {
			DBUtil db = new DBUtil();
			Connection conn = db.getConnection();
			String sql = "INSERT INTO Usertable(UserID,Username,Userpass) VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, userPwd);
			pstmt.executeUpdate();
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	public static int deleteUsr(int userId) {
		try {
			DBUtil db = new DBUtil();
			Connection conn = db.getConnection();
			String sql = "DELETE FROM Usertable WHERE UserID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	public static int updateUsr(int userId, String userName, String userPwd) {
		try {
			DBUtil db = new DBUtil();
			Connection conn = db.getConnection();
			String sql = "UPDATE Usertable SET Username=?, Userpass=? WHERE UserID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPwd);
			pstmt.setInt(3, userId);
			pstmt.executeUpdate();
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	public int insertTask(int taskId, String taskName, String taskCate, String taskJan, String taskFeb, String taskMar,
			String taskApr, String taskMay, String taskJun, String taskJul, String taskAug, String taskSept,
			String taskOct, String taskNov, String taskDec, String taskDept, String taskPrcp, String taskAsstt,
			String taskPfmc, int taskGrade, int taskWeight) {
		try {
			DBUtil db = new DBUtil();
			Connection conn = db.getConnection();
			String sql = "INSERT INTO Tasktable(TaskID,Taskname,Taskcate,Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sept,Oct,Nov,Dece,Department,Principal,Assistant,"
					+ "Performance,Grade,Weight) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, taskId);
			pstmt.setString(2, taskName);
			pstmt.setString(3, taskCate);
			pstmt.setString(4, taskJan);
			pstmt.setString(5, taskFeb);
			pstmt.setString(6, taskMar);
			pstmt.setString(7, taskApr);
			pstmt.setString(8, taskMay);
			pstmt.setString(9, taskJun);
			pstmt.setString(10, taskJul);
			pstmt.setString(11, taskAug);
			pstmt.setString(12, taskSept);
			pstmt.setString(13, taskOct);
			pstmt.setString(14, taskNov);
			pstmt.setString(15, taskDec);
			pstmt.setString(16, taskDept);
			pstmt.setString(17, taskPrcp);
			pstmt.setString(18, taskAsstt);
			pstmt.setString(19, taskPfmc);
			pstmt.setInt(20, taskGrade);
			pstmt.setInt(21, taskWeight);
			pstmt.executeUpdate();
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	public static int updateTask(int taskId, String taskName, String taskCate, String taskJan, String taskFeb,
			String taskMar, String taskApr, String taskMay, String taskJun, String taskJul, String taskAug,
			String taskSept, String taskOct, String taskNov, String taskDec, String taskDept, String taskPrcp,
			String taskAsstt, String taskPfmc, int taskGrade, int taskWeight) {
		try {
			DBUtil db = new DBUtil();
			Connection conn = db.getConnection();
			String sql = "UPDATE Tasktable SET Taskname=?, Taskcate=?, Jan=?, Feb=?, Mar=?, Apr=?, May=?,Jun=?,"
					+ "Jul=?, Aug=?, Sept=?, Oct=?, Nov=?,Dece=?, Department=?, Principal=?, Assistant=?, "
					+ "Performance=?, Grade=?, Weight=? WHERE TaskID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, taskName);
			pstmt.setString(2, taskCate);
			pstmt.setString(3, taskJan);
			pstmt.setString(4, taskFeb);
			pstmt.setString(5, taskMar);
			pstmt.setString(6, taskApr);
			pstmt.setString(7, taskMay);
			pstmt.setString(8, taskJun);
			pstmt.setString(9, taskJul);
			pstmt.setString(10, taskAug);
			pstmt.setString(11, taskSept);
			pstmt.setString(12, taskOct);
			pstmt.setString(13, taskNov);
			pstmt.setString(14, taskDec);
			pstmt.setString(15, taskDept);
			pstmt.setString(16, taskPrcp);
			pstmt.setString(17, taskAsstt);
			pstmt.setString(18, taskPfmc);
			pstmt.setInt(19, taskGrade);
			pstmt.setInt(20, taskWeight);
			pstmt.setInt(21, taskId);
			pstmt.executeUpdate();
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	/**
	 * 按负责人导出
	 * 
	 * @param path
	 * @return
	 */
	public static int outputleader(String path) {
		int n = -1;
		try {
			WritableWorkbook wwb = null;

			// 创建可写入的Excel工作簿
			String fileName = path;
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			// 以fileName为文件名来创建一个Workbook
			wwb = Workbook.createWorkbook(file);

			// 创建工作表
			WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

			// 查询数据库中所有的数据
			List<Principal> list = JxlService.getAllByPrincipal();
			// 要插入到的Excel表格的行号，默认从0开始
			Label labeltaskid = new Label(0, 0, "任务编号");// 表示第
			Label labeltaskprcp = new Label(1, 0, "负责人姓名");
			Label labeltaskGrade = new Label(2, 0, "分值");
			Label labeltaskWeight = new Label(3, 0, "权重");

			ws.addCell(labeltaskid);
			ws.addCell(labeltaskprcp);
			ws.addCell(labeltaskGrade);
			ws.addCell(labeltaskWeight);

			for (int i = 0; i < list.size(); i++) {

				Label labeltaskid_i = new Label(0, i + 1, list.get(i).getId() + "");
				Label labeltaskprcp_i = new Label(1, i + 1, list.get(i).getPrincipal());
				Label labeltaskGrade_i = new Label(2, i + 1, list.get(i).getGrade() + "");
				Label labeltaskWeight_i = new Label(3, i + 1, list.get(i).getWeight() + "");

				ws.addCell(labeltaskid_i);
				ws.addCell(labeltaskprcp_i);
				ws.addCell(labeltaskGrade_i);
				ws.addCell(labeltaskWeight_i);
			}
			n = 1;
			// 写进文档
			wwb.write();
			// 关闭Excel工作簿对象
			wwb.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	public static void delectTablePrcp() {
		DBUtil db = new DBUtil();
		Connection conn = null;
		try {
			conn = db.getConnection();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement stat = null;
		String sql = "truncate table principal";
		int n = -1;
		try {
			stat = conn.prepareStatement(sql);
			n = stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeAll();
	}

	/**
	 * 按负责人汇总到数据库
	 */
	public static int sumPrincipal() {
		DBUtil db = new DBUtil();
		Connection conn = null;
		try {
			conn = db.getConnection();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement stat = null;
		int n = -1;
		String sql = "INSERT INTO principal(principal.taskId,principal.taskPrcp,principal.taskGrade,principal.taskWeight) select Tasktable.TaskID,Tasktable.Principal,Tasktable.Grade,Tasktable.Weight from Tasktable";
		try {
			stat = conn.prepareStatement(sql);
			n = stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeAll();
		return n;
	}

	/**
	 * 按月输出
	 */
	public static int outputMonth(String path) {
		int n = -1;
		try {
			WritableWorkbook wwb = null;

			// 创建可写入的Excel工作簿
			String fileName = path;
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			// 以fileName为文件名来创建一个Workbook
			wwb = Workbook.createWorkbook(file);

			// 创建工作表
			WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

			// 查询数据库中所有的数据
			List<Month> list = JxlService.getAllBymonth();
			// 要插入到的Excel表格的行号，默认从0开始
			Label labelid = new Label(0, 0, "任务编号");// 表示第
			Label labelname = new Label(1, 0, "任务名");
			Label labeltask = new Label(2, 0, "工作内容");
			Label labeldept = new Label(3, 0, "部门");

			ws.addCell(labelid);
			ws.addCell(labelname);
			ws.addCell(labeltask);
			ws.addCell(labeldept);
			for (int i = 0; i < list.size(); i++) {

				Label labeltaskId = new Label(0, i + 1, list.get(i).getId() + "");
				Label labeltaskName = new Label(1, i + 1, list.get(i).getName());
				Label labeltaskTask = new Label(2, i + 1, list.get(i).getTask());
				Label labeltaskDept = new Label(3, i + 1, list.get(i).getDept());
				ws.addCell(labeltaskId);
				ws.addCell(labeltaskName);
				ws.addCell(labeltaskTask);
				ws.addCell(labeltaskDept);
			}
			n = 1;
			// 写进文档
			wwb.write();
			// 关闭Excel工作簿对象
			wwb.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	/**
	 * 按月汇总到数据库
	 * 
	 * @param month
	 * @return
	 */
	public static int sumMonth(int month) {
		DBUtil db = new DBUtil();
		Connection conn = null;
		try {
			conn = db.getConnection();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement stat = null;
		String sql = null;
		int n = -1;
		switch (month) {
		case 1:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Jan,Tasktable.Department from Tasktable";
			break;
		case 2:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Feb,Tasktable.Department from Tasktable";
			break;
		case 3:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Mar,Tasktable.Department from Tasktable";
			break;
		case 4:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Apr,Tasktable.Department from Tasktable";
			break;
		case 5:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.May,Tasktable.Department from Tasktable";
			break;
		case 6:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Jun,Tasktable.Department from Tasktable";
			break;
		case 7:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Jul,Tasktable.Department from Tasktable";
			break;
		case 8:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Aug,Tasktable.Department from Tasktable";
			break;
		case 9:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Sept,Tasktable.Department from Tasktable";
			break;
		case 10:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Oct,Tasktable.Department from Tasktable";
			break;
		case 11:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Nov,Tasktable.Department from Tasktable";
			break;
		case 12:
			sql = "INSERT INTO month(month.taskId,month.taskName,month.task,month.taskDept) select Tasktable.TaskID,Tasktable.Taskname,Tasktable.Dece,Tasktable.Department from Tasktable";
		}

		try {
			stat = conn.prepareStatement(sql);
			n = stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeAll();
		return n;
	}

	public static void delectTableMonth() {
		DBUtil db = new DBUtil();
		Connection conn = null;
		try {
			conn = db.getConnection();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement stat = null;
		String sql = "truncate table month";

		try {
			stat = conn.prepareStatement(sql);
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeAll();

	}
}
