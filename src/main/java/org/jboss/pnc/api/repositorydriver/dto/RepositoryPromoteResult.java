package org.jboss.pnc.api.repositorydriver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.jboss.pnc.api.enums.ResultStatus;

import java.util.Collections;
import java.util.List;

@Data
@Jacksonized
@Builder(builderClassName = "Builder")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryPromoteResult {

    private final List<RepositoryArtifact> builtArtifacts;
    private final List<RepositoryArtifact> dependencies;
    private final String buildContentId;
    private final String message;
    private final ResultStatus status;

    public static RepositoryPromoteResult failed(String buildContentId, String message, ResultStatus status) {
        return new RepositoryPromoteResult(
                Collections.emptyList(),
                Collections.emptyList(),
                buildContentId,
                message,
                status);
    }
}
