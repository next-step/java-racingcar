package calculator;

public class StringCalculator {
    // 최소 입력 갯수
    private static final int MIN_LENGTH = 3;

    private StringCalculator() {
        throw new IllegalStateException("Utility class");
    }

    public static int calculator(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalStateException("입력이 올바르지 않습니다.");
        }

        String[] values = text.split(" ");

        // 최소 입력 갯수 보다 작거나 홀수가 아니면 에러!
        if (values.length < MIN_LENGTH || values.length % 2 != 1) {
            throw new IllegalStateException("입력이 올바르지 않습니다");
        }

        // 첫 번째 인덱스로 결과값 초기화
        int result = Integer.parseInt(values[0]);

        for (int i = 0; i < values.length - 1; i += MIN_LENGTH - 1) {
            String operator = values[i + 1];
            int second = Integer.parseInt(values[i + 2]);
            result = cal(result, operator, second);
        }

        return result;
    }

    /**
     * 연산자로 첫 번째 숫자와 두 번째를 숫자를 연산한다.
     *
     * @param first    첫 번째 숫자
     * @param operator 연산자
     * @param second   두 번째 숫자
     * @return
     */
    private static int cal(int first, String operator, int second) {
        switch (operator) {
            case "+":
                return add(first, second);
            case "-":
                return substract(first, second);
            case "*":
                return multiply(first, second);
            case "/":
                return divide(first, second);
            default:
                throw new IllegalStateException("연산자가 올바르지 않습니다.");
        }
    }

    /**
     * 첫 번째 수를 두 번째 숫자로 나눈다.
     *
     * @param first  첫 번째 숫자
     * @param secont 두 번째 숫자
     * @return
     */
    private static int divide(int first, int secont) {
        return first / secont;
    }

    /**
     * 첫 번째 수에 두 번째 숫자를 곱한다
     *
     * @param first  첫 번째 숫자
     * @param secont 두 번째 숫자
     * @return
     */
    private static int multiply(int first, int secont) {
        return first * secont;
    }

    /**
     * 첫 번째 수에서 두 번째 숫자를 뺀다
     *
     * @param first  첫 번째 숫자
     * @param secont 두 번째 숫자
     * @return
     */
    private static int substract(int first, int secont) {
        return first - secont;
    }

    /**
     * 첫 뻔재 수에 두 번째 수를 더한다.
     *
     * @param first  첫 번째 숫자
     * @param secont 두 번째 숫자
     * @return
     */
    private static int add(int first, int secont) {
        return first + secont;
    }
}