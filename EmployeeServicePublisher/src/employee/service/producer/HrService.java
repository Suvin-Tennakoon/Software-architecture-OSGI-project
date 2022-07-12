package employee.service.producer;

import java.util.ArrayList;

public interface HrService {

	public ArrayList<Employee> allEmployees();
	public void assignTask(String empName, String task);
	public void addEmployee(Employee emp);
	public boolean deleteEmployee(String empName);
}
