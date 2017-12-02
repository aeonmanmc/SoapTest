package com.example;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import my.example.generated_classes.GetStudentRequest;
import my.example.generated_classes.GetStudentResponse;

@Component
public class TestClient extends WebServiceGatewaySupport {

	public GetStudentResponse retrieveResponse(String name) {

		GetStudentRequest request = new GetStudentRequest();
		request.setName(name);

		WebServiceTemplate wst = new WebServiceTemplate();

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("my.example.generated_classes");

		wst.setMarshaller(marshaller);
		wst.setUnmarshaller(marshaller);

		GetStudentResponse response = (GetStudentResponse) wst
				.marshalSendAndReceive("http://localhost:8085/ws/students.wsdl", request);

		return response;
	}

}
