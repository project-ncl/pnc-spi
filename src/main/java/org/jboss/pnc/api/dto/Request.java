/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2021 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.pnc.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.ToString;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@JsonDeserialize(builder = Request.Builder.class)
public class Request {
    private final Method method;
    @Deprecated
    private final URL url;
    private final URI uri;
    private final Set<Header> headers;
    private final Object attachment;

    /**
     * @deprecated use URI instead of URL
     */
    @Deprecated
    public Request(String method, URL url) {
        this(method, url, new HashSet<>(), null);
    }

    /**
     * @deprecated use URI instead of URL
     */
    @Deprecated
    public Request(String method, URL url, Set<Header> headers) {
        this(method, url, headers, null);
    }

    /**
     * @deprecated use URI instead of URL
     */
    @Deprecated
    public Request(String method, URL url, Set<Header> headers, Object attachment) {
        this.method = Method.valueOf(method);
        this.url = url;
        this.headers = headers;
        this.attachment = attachment;
        URI uri = null;
        try {
            if (url != null) {
                uri = url.toURI();
            }
        } catch (URISyntaxException e) {
            // ignore, every URL should be a valid URI
            uri = null;
        }
        this.uri = uri;
    }

    @Deprecated
    public Request(String method, URI uri) {
        this(method, uri, new HashSet<>(), null);
    }

    @Deprecated
    public Request(String method, URI uri, Set<Header> headers) {
        this(method, uri, headers, null);
    }

    @Deprecated
    public Request(String method, URI uri, Set<Header> headers, Object attachment) {
        this.method = Method.valueOf(method);
        this.url = null;
        this.uri = uri;
        this.headers = headers;
        this.attachment = attachment;
    }

    public Request(Method method, URI uri) {
        this(method, uri, new HashSet<>(), null);
    }

    public Request(Method method, URI uri, Set<Header> headers) {
        this(method, uri, headers, null);
    }

    public Request(Method method, URI uri, Set<Header> headers, Object attachment) {
        this.method = method;
        this.url = null;
        this.uri = uri;
        this.headers = headers;
        this.attachment = attachment;
    }

    public Method getMethod() {
        return method;
    }

    /**
     * @deprecated use URI instead of URL
     */
    @Deprecated
    public URL getUrl() {
        return url;
    }

    public URI getUri() {
        return uri;
    }

    public Set<Header> getHeaders() {
        return headers;
    }

    public Object getAttachment() {
        return attachment;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private String method;
        @Deprecated
        private URL url;
        private URI uri;
        private Set<Header> headers;
        private Object attachment;

        private Builder() {
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        /**
         * @deprecated use URI instead of URL
         */
        @Deprecated
        public Builder url(URL url) {
            this.url = url;
            return this;
        }

        public Builder uri(URI uri) {
            this.uri = uri;
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

        public Builder attachment(Object attachment) {
            this.attachment = attachment;
            return this;
        }

        public Request build() {
            if (url != null && uri == null) {
                return new Request(method, url, headers, attachment);
            } else {
                return new Request(method, uri, headers, attachment);
            }
        }
    }

    public enum Method {
        GET, POST, PUT, DELETE, HEAD;
    }

    @ToString
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
