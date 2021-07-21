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
    private Operator operatorValue;

    public CalculationElement(int input) {
        this.intValue = input;
    }

    public CalculationElement(String input) {
        convertInput(input);
    }

    private void convertInput(String input) {
        if (Pattern.matches(NUMBER_PATTERN, input)) { // 숫자로만 이루어진 문자열 이라면 intValue에 저장
            this.intValue = Integer.parseInt(input);
            return;
        }
        // 요구 사항 :: 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
        this.operatorValue = Operator.of(input)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("사칙연산 기호가 아닙니다. [%s]", input)
                ));
    }

    public Optional<Integer> toInt() {
        return Optional.of(intValue);
    }

    public Optional<Operator> toOperator() {
        if (Objects.isNull(operatorValue))
            return Optional.empty();
        return Optional.of(operatorValue);
    }
}