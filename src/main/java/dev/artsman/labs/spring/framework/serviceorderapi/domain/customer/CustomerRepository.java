package dev.artsman.labs.spring.framework.serviceorderapi.domain.customer;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CustomerRepository extends JpaRepository<Customer, Long> {

  Optional<Collection<Customer>> findAllByName(String name);

  Optional<Customer> findByEmail(String email);

  Optional<Collection<Customer>> findAllByPhoneNumber(Long phoneNumber);

}
