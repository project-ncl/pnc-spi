package org.jboss.pnc.api.dependencyanalyzer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import org.jboss.pnc.api.enums.Qualifier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Builder
@ToString
public class QualifiedVersion {

    private final String version;

    @Singular
    private final Map<Qualifier, Set<String>> qualifiers;

    public QualifiedVersion(String version, Map<Qualifier, Set<String>> qualifiers) {
        this.version = version;
        this.qualifiers = qualifiers;
    }

    public QualifiedVersion(String version) {
        this.version = version;
        this.qualifiers = new HashMap<>();
    }

    public static QualifiedVersion of(String version) {
        return new QualifiedVersion(version);
    }

    public boolean has(Qualifier qualifier, String[] values) {
        String joinedValue = Arrays.stream(values).reduce((val1, val2) -> (val1 + ' ' + val2)).orElse(null);

        return qualifiers.containsKey(qualifier) && qualifiers.get(qualifier).contains(joinedValue);
    }
}
