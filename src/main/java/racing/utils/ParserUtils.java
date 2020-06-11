package racing.utils;

public class ParserUtils {

    private static final String COMMA = ",";

    public static String[] stringToArray(String input) {
        InputValid.isEmpty(input);
        return input.split(COMMA);

    }

}
