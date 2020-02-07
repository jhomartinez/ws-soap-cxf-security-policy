package com.jmbmn.webservice.util;

import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.message.token.UsernameToken;
import org.apache.wss4j.dom.validate.Credential;
import org.apache.wss4j.dom.validate.Validator;

public class TokenValidator implements Validator {

	@Override
	public Credential validate(Credential credential, RequestData data) throws WSSecurityException {
		UsernameToken usernameToken = credential.getUsernametoken();
		if("user".equalsIgnoreCase(usernameToken.getName()) && "password".equalsIgnoreCase(usernameToken.getPassword()))
		{
			return credential;
		}
		throw new WSSecurityException(WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);
	}


}
