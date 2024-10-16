package racinggame.domain;

import java.util.List;

public class CommaSplitter implements PatternSplitter {

    private static final String PATTERN = ",";

    @Override
    public List<String> split(String value) {
        return toList(splitNames(value));
    }

    private String[] splitNames(String names) {
        return names.split(PATTERN);
    }

    private List<String> toList(String[] names) {
        return List.of(names);
    }
}
