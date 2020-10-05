package cn.qdlgdx.model;

/**
 * 
 * @author Tim Ma
 *
 */
public class Month {
	private int id;
	private String name;
	private String task;
	private String dept;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Month(int id, String name, String task2, String dept2) {
		super();
		this.id = id;
		this.name = name;
		this.task = task2;
		this.dept = dept2;
	}

	@Override
	public String toString() {
		return "Principal [id=" + id + ", name=" + name + ", task=" + task + ", dept=" + dept + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
