package dev.artsman.labs.spring.framework.serviceorderapi.domain.customer;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
      return new ResponseEntity<>(customers, NO_CONTENT);
    } else {
      return new ResponseEntity<>(customers, OK);
    }
  }

}
