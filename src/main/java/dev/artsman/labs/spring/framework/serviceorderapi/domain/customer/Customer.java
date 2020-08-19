package dev.artsman.labs.spring.framework.serviceorderapi.domain.customer;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "customer")
class Customer {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String email;
  @Column
  private Long phoneNumber;

  /**
   * @deprecated it will be used only for jpa/hibernate framework.
   */
  @Deprecated(forRemoval = false)
  public Customer() {}

  public Customer(Long id, String name, String email, Long phoneNumber) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Long getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(id, customer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return new StringBuffer("Customer{")
      .append("id=").append(id)
      .append(", name='").append(name).append('\'')
      .append(", email='").append(email).append('\'')
      .append(", phoneNumber='").append(phoneNumber).append('\'')
      .append('}')
      .toString();
  }

}
