package org.jboss.pnc.api.dto;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Jacksonized
@Builder(builderClassName = "Builder")
public class ComponentVersion {
    @NonNull
    private String name;
    @NonNull
    private String version;
    private String commit;
    private ZonedDateTime builtOn;
    @lombok.Singular
    private List<ComponentVersion> components;

    public void addComponent(ComponentVersion version) {
        if (components == null) {
            components = new ArrayList<>();
        }
        components.add(version);
    }
}
