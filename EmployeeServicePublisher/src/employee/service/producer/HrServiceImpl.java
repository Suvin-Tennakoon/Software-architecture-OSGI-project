package employee.service.producer;

import java.util.ArrayList;

public class HrServiceImpl implements HrService {

	@Override
	public ArrayList<Employee> allEmployees() {
		// TODO Auto-generated method stub
		
		return VirtualDB.employees;
	}

	@Override
	public void assignTask(String empName, String task) {
		// TODO Auto-generated method stub

		VirtualDB.employeeTask.put(empName, task);
	}

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		VirtualDB.employees.add(emp);
	}

	@Override
	public boolean deleteEmployee(String empName) {
		// TODO Auto-generated method stub
		ArrayList<Employee> allEmp = VirtualDB.employees;
		for(Employee emp : allEmp) {
			if(emp.getEmpName().equalsIgnoreCase(empName)) {
				return VirtualDB.employees.remove(emp);
			}
		}
		return false;
	}

}
