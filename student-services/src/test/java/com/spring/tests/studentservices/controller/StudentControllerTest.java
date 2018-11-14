package com.spring.tests.studentservices.controller;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.tests.studentservices.StudentServicesApplication;
import com.spring.tests.studentservices.model.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentServicesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveStudentCourse() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/students/Student1/courses/Course1"), HttpMethod.GET, entity, String.class);

		String expected = "{\"id\":\"Course1\",\"name\":\"Name 1\",\"description\":\"Description 1\",\"steps\":[\"Step 1\",\"Step 2\",\"Step 3\",\"Step 4\"]}";

		JSONAssert.assertEquals(expected, response.getBody(), true);
	}

	@Test
	public void addCourse() {

		Course course = new Course("Course1", "Spring", "10 Steps", Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

		HttpEntity<Course> entity = new HttpEntity<Course>(course, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/students/Student1/courses"), HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		Assert.assertTrue(actual.contains("/students/Student1/courses/"));

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
