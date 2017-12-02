package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import my.example.generated_classes.GetStudentRequest;
import my.example.generated_classes.GetStudentResponse;

@Endpoint
public class StudentEndpoint {

	private static final String URI = "http://example.my/generated_classes";

	@Autowired
	private StudentRepository studentRepository;

	@PayloadRoot(namespace = URI, localPart = "getStudentRequest")
	@ResponsePayload
	public GetStudentResponse retrieveStudent(@RequestPayload GetStudentRequest request) {
		GetStudentResponse response = new GetStudentResponse();
		response.setStudent(studentRepository.retrieveStudentInfo(request.getName()));

		return response;
	}

}
