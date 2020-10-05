package cn.qdlgdx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.qdlgdx.model.TaskModel;
import cn.qdlgdx.service.JxlService;
import cn.qdlgdx.util.DBUtil;

/**
 * 
 * @author Tim Ma
 *
 */
public class SecretaryDao {

	public static int insertTask(int taskId, String taskName, String taskCate, String taskJan, String taskFeb,
			String taskMar, String taskApr, String taskMay, String taskJun, String taskJul, String taskAug,
			String taskSept, String taskOct, String taskNov, String taskDec, String taskDept, String taskPrcp,
			String taskAsstt, String taskPfmc, int taskGrade, int taskWeight) {
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

	public static String[] selectTask(String taskId) {
		String[] usr = null;
		try {
			DBUtil db = new DBUtil();
			db.getConnection();
			String sql = "SELECT * FROM Tasktable WHERE TaskID=" + taskId;
			ResultSet rs = db.executeQuery(sql, null);
			while (rs.next()) {
				usr = new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
						rs.getString(20), rs.getString(21) };
			}
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return usr;
	}

	public static int deleteTask(int taskId) {
		try {
			DBUtil db = new DBUtil();
			Connection conn = db.getConnection();
			String sql = "DELETE FROM Tasktable WHERE TaskID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, taskId);
			pstmt.executeUpdate();
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	public int taskInput(String workPath) {
		int n = -1;
		List<TaskModel> listExcel = JxlService.getAllByWork(workPath);
		DBUtil db = new DBUtil();
		for (TaskModel TaskModel : listExcel) {
			int id = TaskModel.getTaskId();
			if (!JxlService.isExist(id)) {
				// 不存在就添加
				String sql = "insert into Tasktable (Taskname,Taskcate,Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sept,Oct,Nov,Dece,Department,Principal,Assistant,Performance,Grade,Weight) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				String[] str = new String[] { TaskModel.getTaskName(), TaskModel.getTaskCate(), TaskModel.getTaskJan(),
						TaskModel.getTaskFeb(), TaskModel.getTaskMar(), TaskModel.getTaskApr(), TaskModel.getTaskMay(),
						TaskModel.getTaskJun(), TaskModel.getTaskJul(), TaskModel.getTaskAug(), TaskModel.getTaskSept(),
						TaskModel.getTaskOct(), TaskModel.getTaskNov(), TaskModel.getTaskDec(), TaskModel.getTaskDept(),
						TaskModel.getTaskPrcp(), TaskModel.getTaskAsstt(), TaskModel.getTaskPfmc(),
						String.valueOf(TaskModel.getTaskGrade()), String.valueOf(TaskModel.getTaskWeight()) + "" };
				db.executeUpdate(sql, str);
				n = 0;
			} else {
				// 存在就更新
				String sql = "UPDATE Tasktable SET Taskname=?, Taskcate=?, Jan=?, Feb=?, Mar=?, Apr=?, May=?,Jun=?,Jul=?, Aug=?, Sept=?, Oct=?, Nov=?,Dece=?, Department=?, Principal=?, Assistant=?, Performance=?, Grade=?, Weight=? WHERE TaskID=?";
				String[] str = new String[] { TaskModel.getTaskName(), TaskModel.getTaskCate(), TaskModel.getTaskJan(),
						TaskModel.getTaskFeb(), TaskModel.getTaskMar(), TaskModel.getTaskApr(), TaskModel.getTaskMay(),
						TaskModel.getTaskJun(), TaskModel.getTaskJul(), TaskModel.getTaskAug(), TaskModel.getTaskSept(),
						TaskModel.getTaskOct(), TaskModel.getTaskNov(), TaskModel.getTaskDec(), TaskModel.getTaskDept(),
						TaskModel.getTaskPrcp(), TaskModel.getTaskAsstt(), TaskModel.getTaskPfmc(),
						String.valueOf(TaskModel.getTaskGrade()), String.valueOf(TaskModel.getTaskWeight()),
						String.valueOf(TaskModel.getTaskId()) + "" };
				db.executeUpdate(sql, str);
				n = 0;
			}
		}
		return n;
	}
}
