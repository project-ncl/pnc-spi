package org.jboss.pnc.api.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.pnc.api.constants.HttpHeaders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

class RequestSerializationTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldDeserializeRequest() throws MalformedURLException, JsonProcessingException {
        Set<Request.Header> headers = new HashSet<>();
        headers.add(new Request.Header(HttpHeaders.AUTHORIZATION_STRING, "Bearer 12345"));
        Request request = new Request("GET", new URL("http://localhost/"), headers);
        String serialized = objectMapper.writeValueAsString(request);

        Request deserialized = objectMapper.readValue(serialized, Request.class);
        Assertions.assertEquals("GET", deserialized.getMethod());
    }
}