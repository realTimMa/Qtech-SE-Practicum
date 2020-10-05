package cn.qdlgdx.model;

/**
 * 
 * @author Tim Ma
 *
 */
public class TaskModel {
	int taskId;
	String taskName;
	String taskCate;
	String taskJan;
	String taskFeb;
	String taskMar;
	String taskApr;
	String taskMay;
	String taskJun;
	String taskJul;
	String taskAug;
	String taskSept;
	String taskOct;
	String taskNov;
	String taskDec;
	String taskDept;
	String taskPrcp;
	String taskAsstt;
	String taskPfmc;
	int taskGrade;
	int taskWeight;

	public void TaskModel(int taskId, String taskName, String taskCate, String taskJan, String taskFeb, String taskMar,
			String taskApr, String taskMay, String taskJun, String taskJul, String taskAug, String taskSept,
			String taskOct, String taskNov, String taskDec, String taskDept, String taskPrcp, String taskAsstt,
			String taskPfmc, int taskGrade, int taskWeight) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskCate = taskCate;
		this.taskJan = taskJan;
		this.taskFeb = taskFeb;
		this.taskMar = taskMar;
		this.taskApr = taskApr;
		this.taskMay = taskMay;
		this.taskJun = taskJun;
		this.taskJul = taskJul;
		this.taskAug = taskAug;
		this.taskSept = taskSept;
		this.taskOct = taskOct;
		this.taskNov = taskNov;
		this.taskDec = taskDec;
		this.taskDept = taskDept;
		this.taskPrcp = taskPrcp;
		this.taskAsstt = taskAsstt;
		this.taskPfmc = taskPfmc;
		this.taskGrade = taskGrade;
		this.taskWeight = taskWeight;
	}

	@Override
	public String toString() {
		return "TaskModel [taskId=" + taskId + ", taskName=" + taskName + ", taskCate=" + taskCate + ", taskJan="
				+ taskJan + ", taskFeb=" + taskFeb + ", taskMar=" + taskMar + ", taskApr=" + taskApr + ", taskMay="
				+ taskMay + ", taskJun=" + taskJun + ", taskJul=" + taskJul + ", taskAug=" + taskAug + ", taskSept="
				+ taskSept + ", taskOct=" + taskOct + ", taskNov=" + taskNov + ", taskDec=" + taskDec + ", taskDept="
				+ taskDept + ", taskPrcp=" + taskPrcp + ", taskAsstt=" + taskAsstt + ", taskPfmc=" + taskPfmc
				+ ", taskGrade=" + taskGrade + ", taskWeight=" + taskWeight + "]";
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCate() {
		return taskCate;
	}

	public void setTaskCate(String taskCate) {
		this.taskCate = taskCate;
	}

	public String getTaskJan() {
		return taskJan;
	}

	public void setTaskJan(String taskJan) {
		this.taskJan = taskJan;
	}

	public String getTaskFeb() {
		return taskFeb;
	}

	public void setTaskFeb(String taskFeb) {
		this.taskFeb = taskFeb;
	}

	public String getTaskMar() {
		return taskMar;
	}

	public void setTaskMar(String taskMar) {
		this.taskMar = taskMar;
	}

	public String getTaskApr() {
		return taskApr;
	}

	public void setTaskApr(String taskApr) {
		this.taskApr = taskApr;
	}

	public String getTaskMay() {
		return taskMay;
	}

	public void setTaskMay(String taskMay) {
		this.taskMay = taskMay;
	}

	public String getTaskJun() {
		return taskJun;
	}

	public void setTaskJun(String taskJun) {
		this.taskJun = taskJun;
	}

	public String getTaskJul() {
		return taskJul;
	}

	public void setTaskJul(String taskJul) {
		this.taskJul = taskJul;
	}

	public String getTaskAug() {
		return taskAug;
	}

	public void setTaskAug(String taskAug) {
		this.taskAug = taskAug;
	}

	public String getTaskSept() {
		return taskSept;
	}

	public void setTaskSept(String taskSept) {
		this.taskSept = taskSept;
	}

	public String getTaskOct() {
		return taskOct;
	}

	public void setTaskOct(String taskOct) {
		this.taskOct = taskOct;
	}

	public String getTaskNov() {
		return taskNov;
	}

	public void setTaskNov(String taskNov) {
		this.taskNov = taskNov;
	}

	public String getTaskDec() {
		return taskDec;
	}

	public void setTaskDec(String taskDec) {
		this.taskDec = taskDec;
	}

	public String getTaskDept() {
		return taskDept;
	}

	public void setTaskDept(String taskDept) {
		this.taskDept = taskDept;
	}

	public String getTaskPrcp() {
		return taskPrcp;
	}

	public void setTaskPrcp(String taskPrcp) {
		this.taskPrcp = taskPrcp;
	}

	public String getTaskAsstt() {
		return taskAsstt;
	}

	public void setTaskAsstt(String taskAsstt) {
		this.taskAsstt = taskAsstt;
	}

	public String getTaskPfmc() {
		return taskPfmc;
	}

	public void setTaskPfmc(String taskPfmc) {
		this.taskPfmc = taskPfmc;
	}

	public int getTaskGrade() {
		return taskGrade;
	}

	public void setTaskGrade(int taskGrade) {
		this.taskGrade = taskGrade;
	}

	public int getTaskWeight() {
		return taskWeight;
	}

	public void setTaskWeight(int taskWeight) {
		this.taskWeight = taskWeight;
	}

}
