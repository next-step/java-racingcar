package step2.domain;

import step2.StringUtils;

public class Calculator {
    public static final String NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE = "빈 값이 입력되었습니다.";
    public static final String SPACE = " ";

    public static Integer calculate(String expression) {
        String[] elements = splitExpression(expression);
        assertExpression(elements);

        int result = StringUtils.parseStringToInt(elements[0]);

        for(int i = 0; i < elements.length - 1; i += 2) {
            String operator = elements[i+1];

            int left = result;
            int right = StringUtils.parseStringToInt(elements[i+2]);

            result = Operator.fromString(operator)
                    .calculate(left, right);
        }

        return result;
    }

    public static String[] splitExpression(String expression) {
        return expression.split(SPACE);
    }

    private static void assertExpression(String[] elements) {
        for(String element : elements) {
            assertNullOrEmpty(element);
        }
    }

    public static void assertNullOrEmpty(String string) {
        if(StringUtils.isNullOrEmpty(string)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE);
        }
    }
}
