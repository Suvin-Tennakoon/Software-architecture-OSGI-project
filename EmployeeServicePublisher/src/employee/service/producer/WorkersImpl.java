package employee.service.producer;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkersImpl implements Workers {

	@Override
	public double calculateOT(String empName, int otOrs) {
		// TODO Auto-generated method stub
		ArrayList<Employee> allEmps = VirtualDB.employees;
		for(Employee emp : allEmps) {
			if(empName.equalsIgnoreCase(emp.getEmpName())) {
				switch(emp.getEmpType()) {
				case 1:
					return 3*otOrs*150;
				case 2:
					return 2*otOrs*150;
				case 3:
					return 1*otOrs*150;
				default:
					break;
				}
			}
		}
		return 0;
	}

	@Override
	public String checkAssignedTask(String empName) {
		// TODO Auto-generated method stub
		HashMap<String, String> tasks = VirtualDB.employeeTask;
			return tasks.get(empName);
	}

	@Override
	public boolean removeAssignedTask(String empName) {
		// TODO Auto-generated method stub
		HashMap<String, String> tasks = VirtualDB.employeeTask;
		return tasks.remove(empName, tasks.get(empName));
	}

}
