package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.example.generated_classes.GetStudentResponse;

@Controller
public class TestController {

	@Autowired
	private TestClient testClient;

	@RequestMapping(value = "/{name}", produces = "text/plain")
	@ResponseBody
	public String respondToRequest(@PathVariable String name) {

		GetStudentResponse response = testClient.retrieveResponse(name);

		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" is aged: ");
		sb.append(response.getStudent().getAge());

		return sb.toString();
	}
}
