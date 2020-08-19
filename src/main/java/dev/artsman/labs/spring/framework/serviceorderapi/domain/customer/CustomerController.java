package dev.artsman.labs.spring.framework.serviceorderapi.domain.customer;

import static java.util.List.of;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
class CustomerController {

  @GetMapping
  public Collection<Customer> all() {
    var batman = new Customer(1L, "Batman", "batman@gotham.mail", 111111111L);
    var joker = new Customer(2L, "Joker", "joker@gotham.mail", 222222222L);
    return of(batman, joker);
  }

}
