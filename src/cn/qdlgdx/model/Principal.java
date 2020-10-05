package cn.qdlgdx.model;

/**
 * 
 * @author Tim Ma
 *
 */
public class Principal {
	private int id;
	private String principal;
	private int grade;
	private int weight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Principal(int id, String principal, int grade, int weight) {
		super();
		this.id = id;
		this.principal = principal;
		this.grade = grade;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Principal [id=" + id + ", principal=" + principal + ", grade=" + grade + ", weight=" + weight
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
