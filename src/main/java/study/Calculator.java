package study;

import java.util.Objects;

public class Calculator {
    private static int MIN_EXPRESS_LENGTH = 3;

    public static int calculate(String param) {
        String[] values = validateParameter(param);

        Number result = new Number(values[0]);
        for(int i = 1; i < values.length; i = i + 2){
            result = calculate(result, values[i], new Number(values[i+1]));
        }
        return result.getNumber();
    }

    /**
     * 입력값 정상 여부 확인
     * @param param
     * @return
     */
    private static String[] validateParameter(String param) {
        validationExceptionCheck(Objects.isNull(param), param.isEmpty());

        String[] values = param.split(" ");
        validationExceptionCheck(values.length < MIN_EXPRESS_LENGTH, values.length % 2 == 0);
        return values;
    }

    private static void validationExceptionCheck(boolean b, boolean b2) {
        if (b || b2) {
            throw new IllegalArgumentException("입력 문자열이 정상적이지 않습니다.");
        }
    }

    /**
     * 사칙연산 계산
     * @param first
     * @param operator
     * @param second
     * @return
     */
    private static Number calculate(Number first, String operator, Number second) {
        return Operator.operator(operator).operate(first, second);
    }

}
