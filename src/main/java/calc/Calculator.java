package calc;

public class Calculator {

    public static final String PLUS = "+";

    public static final String MINUS = "-";

    public static final String TIMES = "*";

    public static final String OBELUS = "/";

    public static int add(int pre, int post) {
        return pre + post;
    }

    public static int subtract(int pre, int post) {
        return pre - post;
    }

    public static int multiply(int pre, int post) {
        return pre * post;
    }

    public static int divide(int pre, int post) {
        return pre / post;
    }

    public static int operate(int pre, int post, String operation) {

        // pre 를 0 으로 나눌 경우 ArithmeticException 발생
        // 0 으로 나눌 경우 0 을 리턴
        if (post == 0) {
            return 0;
        }

        switch (operation) {
            case PLUS:
                return add(pre, post);
            case MINUS:
                return subtract(pre, post);
            case TIMES:
                return multiply(pre, post);
            case OBELUS:
                return divide(pre, post);
            default:
                return 0;
        }
    }
}
