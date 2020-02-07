package com.jmbmn.webservice.ws.impl;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jmbmn.webservice.entity.ws.types.CardType;
import com.jmbmn.webservice.entity.ws.types.GetUserCardsRequest;
import com.jmbmn.webservice.entity.ws.types.GetUserCardsResponse;
import com.jmbmn.webservice.entity.ws.types.ListCardType;
import com.jmbmn.webservice.services.checkoutws.ws.Cardws;

@WebService(
		serviceName = "checkoutws",
		targetNamespace = "http://webservice.jmbmn.com/services/checkoutws/ws",
		portName = "cardws",
		endpointInterface = "com.jmbmn.webservice.services.checkoutws.ws.Cardws",
		wsdlLocation = "file:/home/jhon/eclipse-workspace/webservice/src/main/resources/META-INF/wsdl/checkoutws.wsdl"
		)
@BindingType(SOAPBinding.SOAP11HTTP_BINDING)
public class CardWSImpl implements Cardws {

	private static final Logger logger = LogManager.getLogger(CardWSImpl.class.getName());

	@Override
	public GetUserCardsResponse getUserCards(GetUserCardsRequest request) {
		logger.info("Servicio esta activo");
		GetUserCardsResponse response = new GetUserCardsResponse();
		ListCardType listaType = new ListCardType();
		
		CardType card = new CardType();
		card.setAlias("Alias");
		card.setFavorite(true);
		card.setFranchise("Mastercard");
		card.setId(530695);
		card.setState("Active");
		card.setInternationalCard(true);
		
		listaType.getCard().add(card);
		
		response.setListCard(listaType);
		
		return response;
	}

}
