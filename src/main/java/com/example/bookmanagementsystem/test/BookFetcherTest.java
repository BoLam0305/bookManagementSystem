package com.example.bookmanagementsystem.test;


import com.netflix.graphql.dgs.DgsQueryExecutor;

import java.util.List;
import java.util.Map;

import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {DgsAutoConfiguration.class, BookFetcherTest.class})
public class BookFetcherTest {

	@Autowired
	DgsQueryExecutor dgsQueryExecutor;

	@Test
	public void books() {
		List<String> titles = dgsQueryExecutor.executeAndExtractJsonPath(
			" { books { id title publication_year}}",
			"data.books[*].title");
		System.out.println(titles);
		assertThat(titles).contains("Whispers in the Wind");
	}
}
