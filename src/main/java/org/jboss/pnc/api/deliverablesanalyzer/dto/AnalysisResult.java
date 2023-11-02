package org.jboss.pnc.api.deliverablesanalyzer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@Builder(builderClassName = "Builder")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisResult {

    @NonNull
    private final String operationId;

    @NonNull
    private final List<FinderResult> results;

    private final boolean scratch;
}
