package dev.artsman.labs.spring.framework.serviceorderapi.exceptionhandler.problem;

public class Field {
  String name;
  String message;

  public Field(String name, String message) {
    this.name = name;
    this.message = message;
  }

  public String getName() {
    return name;
  }

  public String getMessage() {
    return message;
  }

}
