package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CalculatorTest {

    private String[] inputDumy = {"1", "+", "2"};

    static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of("1 + 2"),
                Arguments.of("1 + 2")
        );
    }


    @DisplayName("피연산자가 숫자인지 체크 : success")
    @ParameterizedTest
    @MethodSource("provide")
    public void validateOperand_success(String operand) throws Exception {
        //given
        InputVo inputVo = new InputVo(operand);

        //when
        Calculator calculator = new Calculator(inputVo.getInputSplit());

        //then
        calculator.validateOperand("10");
    }

    @DisplayName("피연산자가 숫자인지 체크 - fail 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1ㅁ", "2d", "d", "-", "29`", "100~00", "^"})
    public void validateOperand2(String operand) throws Exception {
        //given
        Calculator calculator = new Calculator(inputDumy);

        //then
        assertThatThrownBy(() -> {
            calculator.validateOperand(operand);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연산자가 사칙연산인지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    public void validateOperator1(String operator) throws Exception {
        //given
        Calculator calculator = new Calculator(inputDumy);

        //then
        calculator.validateOperator(operator);
    }

    @DisplayName("연산자가 사칙연산인지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"++", "/-", "--", "***", "1", "ㅁ", "a"})
    public void validateOperator2(String operator) throws Exception {
        //given
        Calculator calculator = new Calculator(inputDumy);

        //then
        assertThatThrownBy(() -> {
            calculator.validateOperator(operator);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 테스트")
    @Test
    public void calculate() throws Exception {
        //given
        double num1 = 1;
        double num2 = 2;
        double num4 = 4;
        Calculator calculator = new Calculator(inputDumy);

        //then
        assertAll(
                () -> assertThat(calculator.calculate(num1, num2, "+")).isEqualTo(3),
                () -> assertThat(calculator.calculate(num1, num2, "-")).isEqualTo(-1),
                () -> assertThat(calculator.calculate(num2, num2, "*")).isEqualTo(4),
                () -> assertThat(calculator.calculate(num2, num2, "/")).isEqualTo(1),
                () -> assertThat(calculator.calculate(num2, num2, "+")).isNotEqualTo(1),
                () -> assertThat(calculator.calculate(num2, num2, "_")).isNotEqualTo(1),
                () -> assertThat(calculator.calculate(num2, num2, "*")).isNotEqualTo(1),
                () -> assertThat(calculator.calculate(num2, num2, "/")).isNotEqualTo(2)
        );
    }

    @DisplayName("사용자의 input을 계산")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 2 + 3:6", "5 / 2:2.5", "2 * 3 / 2:3", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    public void calculateUserInput(String input, double expect) throws Exception {
        //given
        String[] inputSplit = new InputVo(input).getInputSplit();
        Calculator calculator = new Calculator(inputSplit);

        //when
        double result = calculator.calculateUserInput();

        //then
        assertThat(result).isEqualTo(expect);
    }
}
