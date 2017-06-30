package trivera.model;

import java.io.File;
import java.rmi.UnmarshalException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import static org.junit.Assert.*;

import trivera.model.Customer;


public class TestCustomerXML {

	@Test
	public void testUnmarshalling() {
		try {
			JAXBContext context = JAXBContext.newInstance(Customer.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Customer harry = (Customer) unmarshaller.unmarshal(new File("xml/harry.xml"));
//			System.out.println(harry);
			assertEquals("Harry", harry.getFirstName());
			assertEquals("Potter", harry.getLastName());
			assertEquals("harry.potter@hogwarts.ac.uk", harry.getEmail());
		} catch (JAXBException e) {
			e.printStackTrace();
			fail("Exception in unmarshalling: " + e.getMessage());
		}
	}
	
	@Test
	public void testMarshalling() {
		try {
			JAXBContext context = JAXBContext.newInstance(Customer.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Customer hermione = new Customer(1234L, "Hermione", "Granger", "+44 0206 193-1515", "hermione.granger@hogwarts.ac.uk", new Date());
			marshaller.marshal(hermione, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
			fail("Exception in marshalling: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new TestCustomerXML().testMarshalling();
	}

}
