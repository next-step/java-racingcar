package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {

    private static final String SEPARATOR = ",";

    private Parser() {
    }

    public static List<String> split(String input) {
        final List<String> names = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(input, SEPARATOR);

        while (st.hasMoreTokens()) {
            final String name = st.nextToken().trim();
            names.add(name);
        }
        return names;
    }
}
