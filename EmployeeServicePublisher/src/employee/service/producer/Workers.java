package employee.service.producer;

public interface Workers {

	public double calculateOT(String empName, int otHrs);
	public String checkAssignedTask(String empName);
	public boolean removeAssignedTask(String empName);
}
