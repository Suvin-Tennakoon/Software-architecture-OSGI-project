package employee.service.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PublisherActivator implements BundleActivator {
	
	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("==========Publisher Service Started==========");
		
		HrService hrService = new HrServiceImpl();
		Workers workers = new WorkersImpl();
		
		serviceRegistration = bundleContext.registerService(HrService.class.getName(), hrService, null);
		serviceRegistration = bundleContext.registerService(Workers.class.getName(), workers, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==========Publisher Service Stopped==========");
		serviceRegistration.unregister();
	}

}
