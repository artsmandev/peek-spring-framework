package dev.artsman.labs.spring.framework.serviceorderapi.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CustomerRepository extends JpaRepository<Customer, Long> {}
