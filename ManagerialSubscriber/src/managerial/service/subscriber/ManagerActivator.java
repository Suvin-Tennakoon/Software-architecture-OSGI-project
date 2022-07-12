package managerial.service.subscriber;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import employee.service.producer.Employee;
import employee.service.producer.HrService;

public class ManagerActivator implements BundleActivator {

	ServiceReference managerServiceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("==========Manager Subscriber Service Started==========");

		managerServiceReference = bundleContext.getServiceReference(HrService.class.getName());
		HrService hrService = (HrService) bundleContext.getService(managerServiceReference);

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\nEnter the respective number for your task:");
			System.out.println("List all Employees          : 1");
			System.out.println("Assign task for an Employee : 2");
			System.out.println("Add new Employee            : 3");
			System.out.println("Delete an Employee          : 4\n");

			switch (sc.nextInt()) {
			case 1:
				ArrayList<Employee> allEmps = hrService.allEmployees();

				System.out.println("Name\t\tBasic\t\tType");

				for (Employee emp : allEmps) {
					System.out.println(emp.getEmpName() + "\t\t" + emp.getStartingSalary() + "\t\t" + emp.getEmpType());
				}
				
				break;

			case 2:
				System.out.print("Enter employee name  : ");
				String empName = sc.next();
				System.out.print("Enter Assigned Room  : ");
				String task = sc.next();

				hrService.assignTask(empName, task);
				
				break;

			case 3:
				System.out.println("Fill the form below:");
				Employee emp = new Employee();

				System.out.print("Employee name  : ");
				emp.setEmpName(sc.next());

				System.out.print("Basic salary   : ");
				emp.setStartingSalary(sc.nextDouble());

				System.out.print("Employee type  : ");
				emp.setEmpType(sc.nextInt());

				hrService.addEmployee(emp);
				
				break;

			case 4:
				System.out.print("Enter employee name want to delete : ");
				String empNa = sc.next();
				if (hrService.deleteEmployee(empNa))
					System.out.println("Employee deleted successfully");
				else
					System.out.println("There is no such employee");
				
				break;

			default:
				System.out.println("Invalid input. Exiting consumer service.");
				return;
			}
		}
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==========Manager Subscriber Service Stopped==========");
		bundleContext.ungetService(managerServiceReference);
	}

}
