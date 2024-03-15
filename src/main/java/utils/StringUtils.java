package utils;

import java.util.List;

public class StringUtils {

    private static final String PARENTHESIS_OF_OPENING = "(";
    private static final String PARENTHESIS_OF_CLOSING = ")";

    public static String removeParentheses(String target) {
        if (!target.startsWith(PARENTHESIS_OF_OPENING) ||
                !target.endsWith(PARENTHESIS_OF_CLOSING)) {
            throw new IllegalArgumentException(target);
        }
        return target.substring(target.indexOf(PARENTHESIS_OF_OPENING) + 1, target.length() - 1);
    }

    public static String join(String delimiter, List<?> list) {
        if (list.isEmpty()) {
            return "";
        }
        String[] names = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            names[i] = list.get(i).toString();
        }

        return String.join(delimiter, names);
    }
}
