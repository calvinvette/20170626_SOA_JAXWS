package trivera.service;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceProvider;

import trivera.model.Customer;

@WebServiceProvider(wsdlLocation="WEB-INF/wsdl/CustomerService.wsdl")
@WebService(endpointInterface="trivera.service.CustomerService", serviceName="CustomerService")
public class CustomerSOAPService implements CustomerService {
	private static Map<Long, Customer> customersById = new Hashtable<>();
	private static Long lastCustomerKey;
	
	static {
		customersById.put(1234L, new Customer(1234L, "Harry", "Potter", "+44 0206 555-1212", "harry@hogwarts.ac.uk", new Date()));
		customersById.put(1235L, new Customer(1235L, "Ron", "Weasley", "+44 0206 555-1212", "ron@hogwarts.ac.uk", new Date()));
		customersById.put(1236L, new Customer(1236L, "Hermione", "Granger", "+44 0206 555-1212", "hermione@hogwarts.ac.uk", new Date()));
		lastCustomerKey = 1236L;
	}
	
	/* (non-Javadoc)
	 * @see trivera.service.CustomerService#saveCustomer(trivera.model.Customer)
	 */
	@Override
	@WebMethod()
	public @WebResult(name="savedCustomer") Customer saveCustomer(@WebParam(name="customer") Customer c) {
		c.setCustomerId(++lastCustomerKey);
		CustomerSOAPService.customersById.put(c.getCustomerId(), c);
		return c;
	}
	
	/* (non-Javadoc)
	 * @see trivera.service.CustomerService#findByCustomerId(java.lang.Long)
	 */
	@Override
	@WebMethod()
	public Customer findByCustomerId(Long customerId) {
		return CustomerSOAPService.customersById.get(customerId);
	}
}
