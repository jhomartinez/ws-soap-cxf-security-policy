package com.jmbmn.webservice.services.checkoutws.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.16
 * 2020-02-06T20:26:45.421-05:00
 * Generated source version: 3.1.16
 * 
 */
@WebService(targetNamespace = "http://webservice.jmbmn.com/services/checkoutws/ws", name = "cardws")
@XmlSeeAlso({com.jmbmn.webservice.entity.ws.types.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Cardws {

    @WebMethod(operationName = "GetUserCards", action = "http://webservice.jmbmn.com/services/checkoutws/ws/GetUserCards")
    @WebResult(name = "GetUserCardsResponse", targetNamespace = "http://webservice.jmbmn.com/entity/ws/types", partName = "response")
    public com.jmbmn.webservice.entity.ws.types.GetUserCardsResponse getUserCards(
        @WebParam(partName = "request", name = "GetUserCardsRequest", targetNamespace = "http://webservice.jmbmn.com/entity/ws/types")
        com.jmbmn.webservice.entity.ws.types.GetUserCardsRequest request
    );
}
