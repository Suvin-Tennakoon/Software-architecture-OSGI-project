package employee.service.producer;

public class Employee {

	private String empName;
	private double startingSalary;
	private int empType;

	public Employee(String empName, double startingSalary, int empType) {
		super();
		this.empName = empName;
		this.startingSalary = startingSalary;
		this.empType = empType;
	}

	public Employee() {
		
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getStartingSalary() {
		return startingSalary;
	}

	public void setStartingSalary(double startingSalary) {
		this.startingSalary = startingSalary;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

}
