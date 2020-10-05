package cn.qdlgdx.service;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qdlgdx.model.Month;
import cn.qdlgdx.model.Principal;
import cn.qdlgdx.model.TaskModel;
import cn.qdlgdx.util.DBUtil;
import jxl.Sheet;
import jxl.Workbook;

/**
 * 工作任务录入
 * @author Tim Ma
 * @param file
 * @return
 */
public class JxlService {
	public static List<TaskModel> getAllByWork(String file) {
		List<TaskModel> list = new ArrayList<TaskModel>();
		try {
			Workbook rwb = Workbook.getWorkbook(new File(file));
			Sheet rs = rwb.getSheet("Test Shee 1");// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行

			for (int i = 1; i < rows; i++) {

				for (int j = 0; j < clos; j++) {
					// 第一个是列数，第二个是行数
					TaskModel TaskModel = new TaskModel();
					String taskId = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列 所以这里得j++
					String taskName = rs.getCell(j++, i).getContents();
					String taskCate = rs.getCell(j++, i).getContents();
					String taskJan = rs.getCell(j++, i).getContents();
					String taskFeb = rs.getCell(j++, i).getContents();
					String taskMar = rs.getCell(j++, i).getContents();
					String taskApr = rs.getCell(j++, i).getContents();
					String taskMay = rs.getCell(j++, i).getContents();
					String taskJun = rs.getCell(j++, i).getContents();
					String taskJul = rs.getCell(j++, i).getContents();
					String taskAug = rs.getCell(j++, i).getContents();
					String taskSept = rs.getCell(j++, i).getContents();
					String taskOct = rs.getCell(j++, i).getContents();
					String taskNov = rs.getCell(j++, i).getContents();
					String taskDec = rs.getCell(j++, i).getContents();
					String taskDept = rs.getCell(j++, i).getContents();
					String taskPrcp = rs.getCell(j++, i).getContents();
					String taskAsstt = rs.getCell(j++, i).getContents();
					String taskPfmc = rs.getCell(j++, i).getContents();
					String taskGrade = rs.getCell(j++, i).getContents();
					String taskWeight = rs.getCell(j++, i).getContents();

					TaskModel.TaskModel(Integer.parseInt(taskId), taskName, taskCate, taskJan, taskFeb, taskMar,
							taskApr, taskMay, taskJun, taskJul, taskAug, taskSept, taskOct, taskNov, taskDec, taskDept,
							taskPrcp, taskAsstt, taskPfmc, Integer.parseInt(taskGrade), Integer.parseInt(taskWeight));
					list.add(TaskModel);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * 查询按负责人汇总表，输出的表中所有的数据
	 * 
	 * @return
	 */
	public static List<Principal> getAllByPrincipal() {
		List<Principal> list = new ArrayList<Principal>();
		try {
			DBUtil db = new DBUtil();
			String sql = "select * from principal";
			ResultSet rs = db.executeQuery(sql, null);
			while (rs.next()) {
				int id = rs.getInt("taskId");
				String Principal = rs.getString("taskprcp");
				int grade = rs.getInt("taskGrade");
				int weight = rs.getInt("taskWeight");

				list.add(new Principal(id, Principal, grade, weight));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询按月汇总表，输出的表中所有的数据
	 * 
	 * @return
	 */
	public static List<Month> getAllBymonth() {
		List<Month> list = new ArrayList<Month>();
		try {
			DBUtil db = new DBUtil();
			String sql = "select * from month";
			ResultSet rs = db.executeQuery(sql, null);
			while (rs.next()) {
				int id = rs.getInt("taskId");
				String name = rs.getString("taskName");

				String task = rs.getString("task");
				String dept = rs.getString("taskDept");

				list.add(new Month(id, name, task, dept));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static boolean isExist(int id) {
		try {
			DBUtil db = new DBUtil();
			ResultSet rs = db.executeQuery("select * from Tasktable where TaskID=?", new String[] { id + "" });
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
