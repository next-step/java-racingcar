package util.calculator;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

/*
    숫자와 사칙 연산 기호를 감싸주는 클래스
    숫자와 사칙 연산 이외의 다른 문자열을 받게 되면 IllegalArgumentException 오류 발생
*/
public class CalculationElement {
    private static final String NUMBER_PATTERN = "^[0-9]+$";
    private int intValue;
    private String strValue;

    public CalculationElement(int input) {
        this.intValue = input;
    }

    public CalculationElement(String input) {
        this.strValue = input;
    }

    private Integer asIntegerValue() {
        if (Objects.nonNull(strValue)) {
            // 숫자로 이루어진 문자열이 아니라면 toInt 메소드가 Optional로 감쌀수 있도록 null 반환
            return Pattern.matches(NUMBER_PATTERN, strValue) ?
                    Integer.parseInt(strValue) : null;
        }
        return intValue;
    }

    public Optional<Integer> toInt() {
        return Optional.ofNullable(
                asIntegerValue());
    }

    public Optional<Operator> toOperator() {
        return Operator.of(strValue);
    }
}