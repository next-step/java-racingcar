package step2;

public class Calculator {
    public static final String NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE = "빈 값이 입력되었습니다.";
    public static final String SPACE = " ";

    public static void assertNullOrEmpty(String string) {
        if(Utils.isNullOrEmpty(string)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE);
        }
    }

    public static String[] splitExpression(String expression) {

        return expression.split(SPACE);
    }
}
