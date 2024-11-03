package com.chat.application.filter;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	public RestTemplate restTemplate = new RestTemplate();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("done");
		String rs = request.getHeader("Authorization");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", rs);

		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);

		ResponseEntity<Object> res = null;

		try {
			res = restTemplate.exchange("http://localhost:8081/auth/user/Profile", HttpMethod.GET, httpEntity,
					Object.class);

		} catch (HttpClientErrorException e) {
			if (e.getStatusCode().value() == 403) {
				response.sendError(403, "Unauthorized");
			}
		}

		filterChain.doFilter(request, response);

	}

}
