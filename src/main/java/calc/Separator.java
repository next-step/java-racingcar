package calc;

public final class Separator {

    private static final String OPERATOR_REG = "[+\\-*/]";

    private static final String NUMBER_REG = "\\d+";

    private Separator() {
    }

    // 주어진 식을 숫자 배열로 스플릿합니다
    public static String[] splitNumbers(final String expression) {
        return expression.split(OPERATOR_REG);
    }

    // 주어진 식을 사칙연산 배열로 스플릿합니다
    public static String[] splitOperators(final String expression) {
        return expression.split(NUMBER_REG);
    }
}
