package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperandTest {

    @DisplayName("Operand를 생성할 때 파라메터로 넣은 문자열 값과 getNumber 리턴 값이 동일한 값인지 확인")
    @Test
    void getNumberStringTest() {
        String givenString = "5";

        Operand operand = Operand.valueOf(givenString);
        Float valueOfNumber = operand.getNumber();

        assertThat(valueOfNumber).isEqualTo(5);
    }

    @DisplayName("Operand를 생성할 때 파라메터로 넣은 Float 값과 getNumber 리턴 값이 동일한 값인지 확인")
    @Test
    void getNumberFloatTest() {
        Float givenFloat = -5.0f;

        Float valueOfNumber = new Operand(givenFloat).getNumber();

        assertThat(valueOfNumber).isEqualTo(givenFloat);
    }

    @DisplayName("주입된 파라메터에 맞게 정상적으로 계산되는 지 테스트")
    @ParameterizedTest
    @MethodSource("getCalculateTestArguments")
    void calculateTest(String afterValue, Operator operator) {
        final float givenValue = (float) 128.5;
        Operand givenOperand = new Operand(givenValue);

        Operand calculatedOperand = givenOperand.calculate(operator, Operand.valueOf(afterValue));
        final Float calculateValue = calculatedOperand.getNumber();

        final Float expectedValue = getExpectedValue(givenValue, Float.valueOf(afterValue), operator);
        assertThat(calculateValue).isEqualTo(expectedValue);
    }

    private Float getExpectedValue(Float givenValue, Float afterValue, Operator operator) {
        switch (operator) {
            case PLUS:
                return givenValue + afterValue;
            case MINUS:
                return givenValue - afterValue;
            case DIVIDE:
                return givenValue / afterValue;
            case MULTIPLY:
                return givenValue * afterValue;
            default:
                throw new IllegalArgumentException("not support operator");
        }
    }

    public static Stream<Arguments> getCalculateTestArguments() {
        return Stream.of(
                Arguments.of("5", Operator.PLUS),
                Arguments.of("5", Operator.MINUS),
                Arguments.of("5", Operator.MULTIPLY),
                Arguments.of("5", Operator.DIVIDE)
        );
    }

}