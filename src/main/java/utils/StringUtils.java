package utils;

public class StringUtils {

    private static final String PARENTHESIS_OF_OPENING = "(";
    private static final String PARENTHESIS_OF_CLOSING = ")";

    public static String removeParentheses(String target) {
        if (!target.startsWith(PARENTHESIS_OF_OPENING) ||
                !target.endsWith(PARENTHESIS_OF_CLOSING)) {
            throw new IllegalArgumentException(target);
        }
        return target.substring(target.indexOf(PARENTHESIS_OF_OPENING) + 1, target.length() -1);
    }
}
