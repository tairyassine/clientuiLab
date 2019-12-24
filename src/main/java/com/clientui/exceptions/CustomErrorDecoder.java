package com.clientui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		
		if(response.status()==404) {
			return new ProductBadRequestException("INEXISTANT");
		}
		
		return defaultErrorDecoder.decode(methodKey, response);
	}

}
