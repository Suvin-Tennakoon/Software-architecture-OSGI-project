package employee.service.subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import employee.service.producer.Workers;

public class EmployeeActivator implements BundleActivator {

	ServiceReference workerServiceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("==========Worker Subscriber Service Started==========");

		workerServiceReference = bundleContext.getServiceReference(Workers.class.getName());
		Workers workers = (Workers) bundleContext.getService(workerServiceReference);

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nEnter the respective number for your task:");
			System.out.println("Calculate OT amount        : 1");
			System.out.println("Check assigned task        : 2");
			System.out.println("Remove task if completed   : 3\n");

			switch (sc.nextInt()) {
			case 1:
				System.out.print("Enter your name : ");
				String empName = sc.next();

				System.out.print("Enter OT hours : ");
				int otHrs = sc.nextInt();

				System.out.println("OT amount = " + workers.calculateOT(empName, otHrs));
				break;

			case 2:
				System.out.print("Enter your name : ");
				String empNme = sc.next();

				System.out.println("Assigned task = " + workers.checkAssignedTask(empNme));
				break;

			case 3:
				System.out.print("Enter your name : ");
				String empN = sc.next();

				if (workers.removeAssignedTask(empN))
					System.out.println("Entry removed successfully");
				else
					System.out.println("Error removing the entry");

				break;

			default:
				System.out.println("Invalid input. Exiting consumer service.");
				return;
			}
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==========Worker Subscriber Service Stopped==========");
		bundleContext.ungetService(workerServiceReference);
	}

}
