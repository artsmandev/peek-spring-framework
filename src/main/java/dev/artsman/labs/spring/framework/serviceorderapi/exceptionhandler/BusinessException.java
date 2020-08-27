package dev.artsman.labs.spring.framework.serviceorderapi.exceptionhandler;

public class BusinessException extends RuntimeException {
  private static final long serialVersionUID = -8912109303015163237L;

  public BusinessException(String message) {
    super(message);
  }

}
