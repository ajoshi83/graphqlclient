package com.poc.springboot.graphqlclient.api;

import com.poc.springboot.graphqlclient.graphql.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/graphql/client/product")
public class ProductClient {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{queryString}")
    public ResponseEntity<String> getAllProducts(@PathVariable final String queryString) throws Exception {
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery(queryString);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:7001/graphql",query,String.class);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<String> getAllProductsInfo(@RequestBody final String requestBodyString) {
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery(requestBodyString);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:7001/graphql",query,String.class);
        return responseEntity;
    }
}
