package utils;

public class StringUtil {
    final static public String WHITESPACE = " ";
    final static public String REGEX_OPERAND = "[0-9]+";
    final static public String REGEX_OPERATOR = "[\\+\\-\\*/]+";

    static public String[] split(String string, String delimiter) {
        return string.split(delimiter);
    }

    static public String[] regexSplit(String string, String regularExpression) {
        return string.split(regularExpression);
    }
}
