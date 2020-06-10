package racing.utils;

import java.util.Optional;

public class ParserUtils {

    private static final String COMMA = ",";

    public static String[] stringToArray(String input) {
        Valid.isEmpty(input);
        return input.split(COMMA);

    }

}
