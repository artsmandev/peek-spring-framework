package dev.artsman.labs.spring.framework.serviceorderapi.domain.customer;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.noContent;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
class CustomerController {
  private CustomerRepository repository;

  @Autowired
  public CustomerController(CustomerRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public ResponseEntity<Collection<Customer>> all() {
    var customers = repository.findAll();
    if (customers.isEmpty()) {
      return noContent().build();
    } else {
      return new ResponseEntity<>(customers, OK);
    }
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<Collection<Customer>> findByName(@PathVariable String name) {
    var customer = repository.findAllByName(name);
    if (customer.isEmpty()) {
      return noContent().build();
    } else {
    return new ResponseEntity<>(customer.get(), OK);
    }
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<Customer> findByEmail(@PathVariable String email) {
    var customer = repository.findByEmail(email);
    if (customer.isEmpty()) {
      return noContent().build();
    } else {
      return new ResponseEntity<>(customer.get(), OK);
    }
  }

  @GetMapping("/phoneNumber/{phoneNumber}")
  public ResponseEntity<Collection<Customer>> findByPhoneNumber(@PathVariable Long phoneNumber) {
    var customer = repository.findAllByPhoneNumber(phoneNumber);
    if (customer.isEmpty()) {
      return noContent().build();
    } else {
      return new ResponseEntity<>(customer.get(), OK);
    }
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public Customer add(@RequestBody Customer customer) {
    return repository.save(customer);
  }

}
