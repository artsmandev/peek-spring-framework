package dev.artsman.labs.spring.framework.serviceorderapi.domain.customer;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity(name = "customer")
class Customer {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column
  private Long id;

  @Size(max = 50)
  @NotBlank
  @Column
  private String name;

  @Size(max = 50)
  @Email
  @NotBlank
  @Column
  private String email;

  @Range(min = 111111111L, max = 999999999L)
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

  public void setId(Long id) {
    this.id = id;
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
