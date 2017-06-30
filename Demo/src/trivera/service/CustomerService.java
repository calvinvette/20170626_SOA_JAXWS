package trivera.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import trivera.model.Customer;

@WebService
public interface CustomerService {

	Customer saveCustomer(Customer c);

	Customer findByCustomerId(Long customerId);

}