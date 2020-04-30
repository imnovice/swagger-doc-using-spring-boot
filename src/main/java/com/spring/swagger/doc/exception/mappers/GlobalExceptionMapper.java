package com.spring.swagger.doc.exception.mappers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.swagger.doc.dto.ErrorMessage;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GlobalExceptionMapper {

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(code = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public ResponseEntity<ErrorMessage> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), 1000, ex.getLocalizedMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorMessage> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), 1001, ex.getLocalizedMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

}
