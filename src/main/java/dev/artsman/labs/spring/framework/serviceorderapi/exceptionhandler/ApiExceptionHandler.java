package dev.artsman.labs.spring.framework.serviceorderapi.exceptionhandler;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import dev.artsman.labs.spring.framework.serviceorderapi.exceptionhandler.problem.Field;
import dev.artsman.labs.spring.framework.serviceorderapi.exceptionhandler.problem.Problem;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class ApiExceptionHandler extends ResponseEntityExceptionHandler {
  private MessageSource messageSource;

  @Autowired
  public ApiExceptionHandler(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<Object> businessHandler(BusinessException exception, WebRequest request) {
    var problem = new Problem(BAD_REQUEST.value(), exception.getMessage());
    return super.handleExceptionInternal(exception, problem, new HttpHeaders(), BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                HttpStatus status, WebRequest request) {
    var fields = new ArrayList<Field>(ex.getBindingResult().getAllErrors().size());
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      var name = ((FieldError) error).getField();
      var message = this.messageSource.getMessage(error, getLocale());
      fields.add(new Field(name, message));
    }
    var problem = new Problem(status.value(),"One or more fields are invalid, please check them and try again", fields);
    return super.handleExceptionInternal(ex, problem, headers, status, request);
  }


}
