/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2014-2020 Red Hat, Inc., and individual contributors
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
package org.jboss.pnc.api.repour.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Repour's clone repository DTO
 */
@Data
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@ToString(callSuper = true)
@JsonDeserialize(builder = RepourCloneRepositoryRequest.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepourCloneRepositoryRequest {

    /**
     * Type of scm: usually: git
     */
    private String type;

    /**
     * Original repository to sync from
     */
    private String originRepoUrl;

    /**
     * Repository to sync to
     */
    private String targetRepoUrl;

    /**
     * Specific reference to sync. Reference can be a tag, branch, or commit id
     */
    private String ref;

    /**
     * Callback specification
     */
    private RepourCloneCallback callback;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
    }
}
