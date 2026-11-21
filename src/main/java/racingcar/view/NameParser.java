package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class NameParser {
    private static final String DELIMITER = ",";

    private NameParser() {
    }

    public static List<String> parse(String input) {
        List<String> names = new ArrayList<>();
        for (String token : input.split(DELIMITER, -1)) {
            names.add(toName(token, input));
        }
        return names;
    }

    private static String toName(String token, String input) {
        String name = token.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("empty name is not allowed [" + input + "]");
        }
        return name;
    }
}
