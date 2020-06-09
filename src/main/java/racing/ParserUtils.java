package racing;

import java.util.Optional;

public class ParserUtils {

    private static final String COMMA = ",";

    public static String[] stringToArray(String input) {
        return Optional.ofNullable(input)
                .filter(text -> !text.trim().isEmpty())
                .map(text -> text.split(COMMA))
                .orElseThrow(IllegalArgumentException::new);
    }

}
