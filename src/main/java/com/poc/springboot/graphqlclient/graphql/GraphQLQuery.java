package com.poc.springboot.graphqlclient.graphql;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GraphQLQuery {
    @JsonProperty("variables")
    private Object variables;
    @JsonProperty("query")
    private String query;
}
