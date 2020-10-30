package calculator;

/**
 * +, -, *, / 연산
 */
public class CommonCalculate {
    /**
     * 뺄셈 연산
     * @param a
     * @param b
     * @return a - b
     */
    public static int subCalculate(final int a, final int b) {
        return a - b;
    }

    /**
     * 곱하기 연산
     * @param a
     * @param b
     * @return a * b
     */
    public static int mulCalculate(final int a, final int b) {
        return a * b;
    }

    /**
     * 나눗셈 연산
     * @param a
     * @param b
     * @return a / b
     */
    public static int divCalculate(final int a, final int b) {
        return a / b;
    }

    /**
     * 덧셈 연산
     * @param a
     * @param b
     * @return a + b
     */
    public static int addCalculate(final int a, final int b) {
        return a + b;
    }
}
