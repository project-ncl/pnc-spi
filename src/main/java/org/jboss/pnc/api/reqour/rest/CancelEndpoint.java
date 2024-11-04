/**
 * Copyright 2024 Red Hat, Inc.
 * SPDX-License-Identifier: Apache-2.0
 */
package org.jboss.pnc.api.reqour.rest;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.pnc.api.constants.OpenapiConstants;
import org.jboss.pnc.api.dto.ErrorResponse;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Endpoint for cancelling asynchronous tasks.
 */
@Tag(name = "Cancel")
@Path("/cancel")
public interface CancelEndpoint {

    String CANCEL_DESC = "Cancel asynchronous operation by its task ID";

    @Operation(summary = CANCEL_DESC)
    @APIResponses({
            @APIResponse(
                    responseCode = OpenapiConstants.ACCEPTED_CODE,
                    description = OpenapiConstants.ACCEPTED_DESCRIPTION),
            @APIResponse(
                    responseCode = OpenapiConstants.CONFLICT_CODE,
                    description = OpenapiConstants.CONFLICT_DESCRIPTION,
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(
                    responseCode = OpenapiConstants.SERVER_ERROR_CODE,
                    description = OpenapiConstants.SERVER_ERROR_DESCRIPTION,
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    @POST
    @Path("/{taskId}")
    void cancelTask(@PathParam("taskId") String taskId);
}
