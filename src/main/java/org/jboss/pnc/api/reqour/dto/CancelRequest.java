/**
 * Copyright 2024 Red Hat, Inc.
 * SPDX-License-Identifier: Apache-2.0
 */
package org.jboss.pnc.api.reqour.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.jboss.pnc.api.dto.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Request DTO used when cancelling a task.
 */
@Builder
@Value
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelRequest {

    /**
     * Task ID to cancel
     */
    @NotBlank
    String taskId;

    /**
     * Callback specification
     */
    @NotNull
    Request callback;
}
