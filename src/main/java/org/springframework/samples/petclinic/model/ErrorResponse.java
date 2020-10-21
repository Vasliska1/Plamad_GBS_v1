package org.springframework.samples.petclinic.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ErrorResponse  implements Serializable  {

	private String error;
	private String status;

	public ErrorResponse(String status, String error) {
		this.error = error;
		this.status = status;
	}
}
