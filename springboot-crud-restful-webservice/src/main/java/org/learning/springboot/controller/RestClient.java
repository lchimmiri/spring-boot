package org.learning.springboot.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.learning.springboot.entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	private static final String GET_ALL_USERS_API = "http://localhost:8080/api/users";
	private static final String GET_USER_BY_ID_API = "http://localhost:8080/api/users/{id}";
	private static final String CREATE_USER_API = "http://localhost:8080/api/users";
	private static final String UPDATE_USER_API = "http://localhost:8080/api/users/{id}";
	private static final String DELETE_USER_API = "http://localhost:8080/api/users/{id}";

	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		callGetUsersAPI();
		callGetUserByIdAPI();
		callCreateUserAPI();
		callUpdateUserByIdAPI();
		callDeleteUserByIdAPI();
	}

	private static void callGetUsersAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USERS_API, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}

	private static void callGetUserByIdAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 5);

		User user = restTemplate.getForObject(GET_USER_BY_ID_API, User.class, param);
		System.out.println(user);
	}

	private static void callCreateUserAPI() {

		User user = new User("naidu", "ch", "naidu@gmail.com");
		ResponseEntity<User> user2 = restTemplate.postForEntity(CREATE_USER_API, user, User.class);
		System.out.println(user2.getBody());
	}

	private static void callUpdateUserByIdAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 12);

		User updateUser = new User("na", "chimm", "naidu@gmail.com");
		restTemplate.put(UPDATE_USER_API, updateUser, param);
	}

	private static void callDeleteUserByIdAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 14);

		restTemplate.delete(DELETE_USER_API, param);
	}
}
