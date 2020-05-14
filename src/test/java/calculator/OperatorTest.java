package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

    @DisplayName("지원하지 않는 연산기호로 getOperator를 호출 할 때 IllegalArgumentException 이 발생함")
    @ParameterizedTest
    @ValueSource(strings = {"%", "&", "@"})
    public void getOperatorExceptionTest(String operatorSymbol) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Operator operator = Operator.getOperator(operatorSymbol);
        });

    }

    @DisplayName("지원하는 연산기호로 getOperator 를 호출 할 때 정상적으로 Operator가 리턴되는지 테스트")
    @ParameterizedTest
    @MethodSource("getOperatorArguments")
    public void getOperatorTest(String operatorSymbol, Operator operator) {
        Operator operatorGroup = Operator.getOperator(operatorSymbol);
        assertThat(operatorGroup).isEqualTo(operator);
    }

    public static Stream<Arguments> getOperatorArguments() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVIDE)
        );
    }

    @DisplayName("문자열이 operator 인지 아닌지 판별 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true", "/,true", "&,false", "$,false"})
    public void isOperatorTest(String symbol, boolean isOperator) {
        assertThat(Operator.isOperatorSymbol(symbol)).isEqualTo(isOperator);
    }

    @DisplayName("연산기호애 맞게 계산이 되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "1,4", "1.5, 2.5", "400, 200"})
    public void calculateTest(float beforeOperand, float nextOperand) {
        Operator plusOperator = Operator.getOperator("+");
        Operator minusOperator = Operator.getOperator("-");
        Operator divideOperator = Operator.getOperator("/");
        Operator multiplyOperator = Operator.getOperator("*");

        float plusCalculated = plusOperator.calculate(beforeOperand, nextOperand);
        float minusCalculated = minusOperator.calculate(beforeOperand, nextOperand);
        float divideCalculated = divideOperator.calculate(beforeOperand, nextOperand);
        float multiplyCalculated = multiplyOperator.calculate(beforeOperand, nextOperand);

        assertThat(plusCalculated).isEqualTo(beforeOperand + nextOperand);
        assertThat(minusCalculated).isEqualTo(beforeOperand - nextOperand);
        assertThat(divideCalculated).isEqualTo(beforeOperand / nextOperand);
        assertThat(multiplyCalculated).isEqualTo(beforeOperand * nextOperand);
    }

    @DisplayName("0으로 나눌 때 ArithmeticException 발생하는 지 확인")
    @Test
    public void calculateDivideZeroTest() {
        Throwable throwable = catchThrowable(() -> {
            Operator divideOperator = Operator.getOperator("/");
            divideOperator.calculate(5, 0);
        });

        assertThat(throwable).isInstanceOf(ArithmeticException.class);
    }
}
