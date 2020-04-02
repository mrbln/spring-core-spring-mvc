
package guru.springframework.services;

import guru.springframework.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    Map<Integer, Customer> customerMap;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer = customerMap.get(id);
        return customer;
    }

    @Override
    public List<Customer> saveOrUpdateCustomer(Customer customer) {
        addCustomerToTheList(customer);
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerMap.remove(id);
    }

    private void loadCustomers() {
        customerMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("AAA");
        customer1.setLastName("AAA");
        customer1.setAddressLine1("AAA Address Line 1");
        customer1.setAddressLine2("AAA Address Line 2");
        customer1.setPhoneNumber("AAA +1 111 1111");
        customer1.setEmail("AAA email");
        customer1.setCity("AAA city");
        customer1.setState("AAA state");
        customer1.setZipcode("AAA zipCode");

        customerMap.put(customer1.getId(), customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("BBB");
        customer2.setLastName("BBB");
        customer2.setAddressLine1("BBB Address Line 1");
        customer2.setAddressLine2("BBB Address Line 2");
        customer2.setPhoneNumber("BBB +2 222 2222");
        customer2.setEmail("BBB email");
        customer2.setCity("BBB city");
        customer2.setState("BBB state");
        customer2.setZipcode("BBB zipCode");

        customerMap.put(customer2.getId(), customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("CCC");
        customer3.setLastName("CCC");
        customer3.setAddressLine1("CCC Address Line 1");
        customer3.setAddressLine2("CCC Address Line 2");
        customer3.setPhoneNumber("CCC +3 333 3333");
        customer3.setEmail("CCC email");
        customer3.setCity("CCC city");
        customer3.setState("CCC state");
        customer3.setZipcode("CCC zipCode");

        customerMap.put(customer3.getId(), customer3);

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setFirstName("DDD");
        customer4.setLastName("DDD");
        customer4.setAddressLine1("DDD Address Line 1");
        customer4.setAddressLine2("DDD Address Line 2");
        customer4.setPhoneNumber("DDD +4 444 4444");
        customer4.setEmail("DDD email");
        customer4.setCity("DDD city");
        customer4.setState("DDD state");
        customer4.setZipcode("DDD zipCode");

        customerMap.put(customer4.getId(), customer4);
    }

    private void addCustomerToTheList(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(getNextKey());
            customerMap.put(customer.getId(), customer);
        } else {
            customerMap.put(customer.getId(), customer);
        }
    }

    private Integer getNextKey(){
        return Collections.max(customerMap.keySet()) + 1;
    }
}
