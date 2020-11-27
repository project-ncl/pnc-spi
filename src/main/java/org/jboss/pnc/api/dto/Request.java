package org.jboss.pnc.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@JsonDeserialize(builder = Request.Builder.class)
public class Request {
    private final String method;
    private final URL url;
    private final Set<Header> headers;

    public Request(String method, URL url) {
        this.method = method;
        this.url = url;
        this.headers = new HashSet<>();
    }

    public Request(String method, URL url, Set<Header> headers) {
        this.method = method;
        this.url = url;
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public URL getUrl() {
        return url;
    }

    public Set<Header> getHeaders() {
        return headers;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private String method;
        private URL url;
        private Set<Header> headers;

        private Builder() {
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder url(URL url) {
            this.url = url;
            return this;
        }

        public Builder headers(Set<Header> headers) {
            this.headers = headers;
            return this;
        }

        public Builder addHeader(Header header) {
            this.headers.add(header);
            return this;
        }

        public Request build() {
            return new Request(method, url, headers);
        }
    }

    public static class Header {
        private String name;
        private String value;

        Header() {
        }

        public Header(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

    }
}
