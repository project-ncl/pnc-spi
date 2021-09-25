package org.jboss.pnc.api.deliverablesanalyzer.dto;

import org.jboss.pnc.api.enums.OperationResult;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder(builderClassName = "Builder")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisResponse {

    @NonNull
    private final OperationResult status;
    @NonNull
    private final String operationId;
    @NonNull
    private final AnalysisResult analysisResult;

}
