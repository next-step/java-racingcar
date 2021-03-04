package calculator;

import com.sun.xml.internal.ws.util.StringUtils;

import javax.xml.crypto.Data;

public class Calculator {

    private static final String SIZE_THREE_DOWN_ERROR = "size 3 more";
    private static final String SIZE_EVEN_ERROR = "even size";
    private static final String ARITHMETIC_SYMBOLS_ERROR = "not arithmetic symbols";
    private static final String NOT_A_NUMBER_ERROR = "not a number";

    /**
     * 사칙연산 구현
     *
     * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
     * 1) 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다. 문자열을 입력한다
     *  -> 사칙연산하려면 문자 개수는 최소 3개가 필요하다
     *  -> split 결과 size 는 홀수여야 한다
     * 2) 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
     *  ->
     * 3) 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
     *   즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     *  -> String -> Int 형변환 필요
     *  -> 첫 문자는 숫자로 시작해야한다
     *  -> 홀수 번호는 숫자여야한다
     *  -> 짝수 번호는 사칙연산 기호여야한다
     * 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     */
    public int work(String text) throws Exception {
        String[] data = stringSplit(text);
        dataSizeCheck(data);

        int result = stringToInt(data[0]);

        for (int i = 1; i < data.length; i+=2) {
            int number = stringToInt(data[i + 1]);

            switch (data[i]) {
                case "+" :
                    result = plus(result, number);
                    break;
                case "-" :
                    result = minus(result, number);
                    break;
                case "*" :
                    result = multiply(result, number);
                    break;
                case "/" :
                    result = divide(result, number);
                    break;
                default :
                    throw new IllegalArgumentException();
            }
        }

        return result;
    }

    private String[] stringSplit(String text) throws Exception {
        stringNullCheck(text);

        return text.split(" ");
    }

    private void dataSizeCheck(String[] data) throws Exception {
        if (data.length < 3 ) {
            throw new Exception(SIZE_THREE_DOWN_ERROR);
        }

        if (data.length % 2 == 0) {
            throw new Exception(SIZE_EVEN_ERROR);
        }
    }

    private int stringToInt(String number) throws Exception {
        stringNullCheck(number);

        return Integer.parseInt(number);
    }

    private void stringNullCheck(String number) throws IllegalArgumentException {
        if (number == null
                || number.trim().isEmpty()) {
            throw new IllegalArgumentException(NOT_A_NUMBER_ERROR);
        }
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}
