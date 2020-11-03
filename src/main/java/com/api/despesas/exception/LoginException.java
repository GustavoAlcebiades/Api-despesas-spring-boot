package com.api.despesas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoginException extends RuntimeException {

	public LoginException(String message) {
		super(message);
	}
}
