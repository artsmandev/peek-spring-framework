package dev.artsman.labs.spring.framework.serviceorderapi.exceptionhandler.problem;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableCollection;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

public class Problem {
  private Integer status;
  private LocalDateTime dateTime;
  private String title;
  private Collection<Field> fields;

  public Problem(Integer status, String title) {
    this.status = status;
    this.title = title;
    this.dateTime = LocalDateTime.now();
  }

  public Problem(Integer status, String title, Collection<Field> fields) {
    this.status = status;
    this.title = title;
    this.fields = fields;
  }

  public Integer getStatus() {
    return status;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public String getTitle() {
    return title;
  }

  public Collection<Field> getFields() {
    return unmodifiableCollection(this.fields);
  }

}
