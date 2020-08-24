package dev.artsman.labs.spring.framework.serviceorderapi.exceptionhandler.problem;

import static java.util.Collections.unmodifiableCollection;

import java.time.LocalDateTime;
import java.util.Collection;

public class Problem {
  private Integer status;
  private LocalDateTime dateTime;
  private String title;
  private Collection<Field> fields;

  public Problem(Integer status, String title, Collection<Field> fields) {
    this.status = status;
    this.title = title;
    this.fields = fields;
    this.dateTime = LocalDateTime.now();
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
