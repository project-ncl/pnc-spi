package org.jboss.pnc.api.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.pnc.api.constants.HttpHeaders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

class RequestSerializationTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldDeserializeRequest() throws JsonProcessingException, URISyntaxException {
        Set<Request.Header> headers = new HashSet<>();
        headers.add(new Request.Header(HttpHeaders.AUTHORIZATION_STRING, "Bearer 12345"));
        Request request = new Request(Request.Method.GET, new URI("http://localhost/"), headers);
        String serialized = objectMapper.writeValueAsString(request);

        Request deserialized = objectMapper.readValue(serialized, Request.class);
        Assertions.assertEquals(Request.Method.GET, deserialized.getMethod());
    }
}