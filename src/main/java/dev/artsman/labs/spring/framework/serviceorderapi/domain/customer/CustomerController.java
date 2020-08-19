package dev.artsman.labs.spring.framework.serviceorderapi.domain.customer;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
class CustomerController {

  @PersistenceContext
  private EntityManager manager;

  @GetMapping
  public ResponseEntity<Collection<Customer>> all() {
    var customers = manager.createQuery("select c from customer c", Customer.class).getResultList();
    if (customers.isEmpty()) {
      return new ResponseEntity<>(customers, NO_CONTENT);
    } else {
      return new ResponseEntity<>(customers, OK);
    }
  }

}
