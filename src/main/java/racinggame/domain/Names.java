package racinggame.domain;

import java.util.Collections;
import java.util.List;

public class Names {

    private final List<String> names;

    public Names(String names, PatternSplitter patternSplitter) {
        this.names = Collections.unmodifiableList(patternSplitter.split(names));
    }

    public List<String> split() {
        return names;
    }
}
