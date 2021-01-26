package com.training.exceptions;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice
	public class ExceptionController {

		@ExceptionHandler(OrderServiceExp.class)
		public ResponseEntity<OrderError> mapException(OrderServiceExp ex) {
			OrderError error = new OrderError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
			return new ResponseEntity<OrderError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

