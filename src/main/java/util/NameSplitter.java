package util;

import java.util.List;

public final class NameSplitter {

    private NameSplitter() {
    }

    public static List<String> split(final String names) {
        return List.of(names.split(","));
    }
}
