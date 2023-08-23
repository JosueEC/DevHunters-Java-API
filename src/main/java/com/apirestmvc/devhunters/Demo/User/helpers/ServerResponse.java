package com.apirestmvc.devhunters.Demo.User.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse {
	private boolean error;
	private String message;
	private Object data;
	
	public ServerResponse (String message) {
		this.error = true;
		this.message = message;
	}
	
	public ServerResponse (Object data) {
		this.error = false;
		this.data = data;
	}
}
