package racinggame.domain;

import java.util.Collections;
import java.util.List;

public class CommaPatternNames implements Names {

    private static final String PATTERN = ",";
    private final List<String> names;

    public CommaPatternNames(String value) {
        this.names = toList(splitNames(value));
    }

    @Override
    public List<String> split() {
        return names;
    }

    private String[] splitNames(String names) {
        return names.split(PATTERN);
    }

    private List<String> toList(String[] names) {
        return List.of(names);
    }


}
