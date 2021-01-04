package org.jboss.pnc.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Data
@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = HeartbeatConfig.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeartbeatConfig {
    private final Request request;
    private final Long delay;
    private final TimeUnit delayTimeUnit;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
    }
}
