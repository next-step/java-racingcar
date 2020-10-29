package step2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

public class StringCalculator {
    private final String DELIMETER = " ";
    private final String OPERATOR_PATTERN = "[+\\-*/]";
    private final String NUMBER_PATTERN = "(^\\d*)$";
    private final Map<String, BinaryOperator<Integer>> functionByOperator = new HashMap<String, BinaryOperator<Integer>>() {{
        put("+", Integer::sum);
        put("-", (i, j) -> i - j);
        put("*", (i, j) -> i * j);
        put("/", (i, j) -> i / j);
    }};


    /**
     * @ImplSpec
     * 인자값으로 문자열을 받아 DELEMITER기준으로 분할하여 문자열의 첫 번째 요소부터 순회하며 사칙연산을 수행하는 메소드
     */
    protected Integer calculate(String input) {
        isEmpty(input);
        String[] strings = input.split(DELIMETER);
        Integer total = 0;
        for (int i = 0; i < strings.length; i++) {
            String currentValue = strings[i];
            isValid(currentValue);
            if (isOperator(currentValue)) {
                total = functionByOperator.get(currentValue).apply(total, Integer.parseInt(strings[i + 1]));
                i++;
                continue;
            }
            total = Integer.parseInt(currentValue);
        }
        return total;
    }

    //사칙연산 기호인지 검증한다.
    protected boolean isOperator(String input) {
        return input.matches(OPERATOR_PATTERN);
    }

    //인자값이 숫자인지 검증한다.
    protected boolean isNumber(String input) {
        return input.matches(NUMBER_PATTERN);
    }

    //인자값이 null이거나 공백인지 검증한다.
    protected void isEmpty(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("입력 값은 null이거나 빈 공백문자여서는 안됩니다.");
    }

    //인자값이 유효한 인자값(숫자이거나 사칙연산기호)인지 확인한다.
    protected void isValid(String input) {
        isEmpty(input);
        if (!isOperator(input) && !isNumber(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

}
