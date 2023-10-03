package com.example.bookmanagementsystem.test;


import com.netflix.graphql.dgs.DgsQueryExecutor;
import java.util.Map;
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


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookFetcherTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@MockBean
	DgsQueryExecutor dgsQueryExecutor;


	@Test
	public void books() {

		// Prepare the GraphQL mutation
		String query = """
                query{
                    books{
                        title
                    }
                }
            """;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<>(query, headers);

		// Send the GraphQL request and receive the response
		ResponseEntity<Map> responseEntity = testRestTemplate.postForEntity("/graphql", requestEntity, Map.class);
		System.out.println(responseEntity.toString());



		//		ExecutionResult result = dgsQueryExecutor.execute(" { books {id title publication_year }}");
//		System.out.println(result.toString());
////		List<String> titles = dgsQueryExecutor.executeAndExtractJsonPath(
////			" { books {id title publication_year }}",
////			"data.books[*].id");
////		System.out.println(titles.size());
	}
}
