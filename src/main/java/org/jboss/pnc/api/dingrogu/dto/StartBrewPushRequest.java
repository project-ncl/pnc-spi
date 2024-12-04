package org.jboss.pnc.api.dingrogu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;

@Builder
@Value
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartBrewPushRequest {

    @NotNull
    String buildId;

    @NotNull
    String tagPrefix;

    @NotNull
    String username;

    boolean reimport;
}
