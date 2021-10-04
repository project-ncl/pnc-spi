package org.jboss.pnc.api.repositorydriver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import org.jboss.pnc.api.enums.BuildType;

@AllArgsConstructor
@Builder
@Jacksonized
@Getter
public class RepositorySealRequest {
    private final String buildContentId;
    private final BuildType buildType;
}
