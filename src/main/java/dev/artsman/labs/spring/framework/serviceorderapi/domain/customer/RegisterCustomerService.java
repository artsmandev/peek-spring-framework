package dev.artsman.labs.spring.framework.serviceorderapi.domain.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.artsman.labs.spring.framework.serviceorderapi.exceptionhandler.BusinessException;

@Service
class RegisterCustomerService {
  private CustomerRepository repository;

  @Autowired
  public RegisterCustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  public Customer save(Customer customer) {
    Optional<Customer> customerFound = this.repository.findByEmail(customer.getEmail());
    if (customerFound.isPresent() && !customerFound.get().equals(customer)) {
      throw new BusinessException("E-mail already exists");
    }
    return this.repository.save(customer);
  }

  public void deleteById(long id) {
    this.repository.deleteById(id);
  }

}
