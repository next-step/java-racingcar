package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorParserTest {

    @DisplayName("parserExpression() 테스트 케이스 : 실패 케이스 -> input 데이터가 null인 경우")
    @Test
    void parserExpression1() {
        String input = null;

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            CalculatorParser.parseExpression(input);
        });
    }

    @DisplayName("parserExpression() 테스트 케이스 : 실패 케이스 -> input 데이터가 공백인 경우")
    @Test
    void parserExpression2() {
        String input = "";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            CalculatorParser.parseExpression(input);
        });
    }

    @DisplayName("parserExpression 테스트 케이스 : 정상 케이스 -> input 데이터가 정상적으로 배열 값으로 파싱되는지 테스트")
    @Test
    void parserExpression3() {
        String input = "1 * 3 + 7";
        String[] expectedExpression = {"1", "*", "3", "+", "7"};

        String[] expression = CalculatorParser.parseExpression(input);

        assertThat(expression).isEqualTo(expectedExpression);
    }


    @DisplayName("getInitialValue() 테스트 케이스 : 실패 케이스 -> 초기값이 숫자가 아닌 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {" $ + 1", "* 7"})
    void getInitialValue1(String input) {
        String[] expression = CalculatorParser.parseExpression(input);

        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            CalculatorParser.getInitialValue(expression);
        });
    }

    @DisplayName("getInitialValue() 테스트 케이스 : 정상케이스")
    @ParameterizedTest(name = "수식 {0} 의 초기값은 = {1}")
    @CsvSource(value = {
            // input, expectedInitialValue
            "        1 + 2 |   1 ",
            " 165 * 14 + 8 | 165 ",
    }, delimiter = '|')
    void getInitialValue2(String input, int expectedInitialValue) {
        String[] expression = CalculatorParser.parseExpression(input);

        assertThat(CalculatorParser.getInitialValue(expression))
                .isEqualTo(expectedInitialValue);
    }


    @DisplayName("getInitialValue() 테스트 케이스 : 계산식의 사칙연산을 Operator List 형태로 가져오기")
    @Test
    void getOperatorList() {
        String input = "1 + 7 * 7 / 2";
        String[] expression = CalculatorParser.parseExpression(input);

        List<Operator> operators = CalculatorParser.getOperatorList(expression);

        assertThat(operators.get(0)).isEqualTo(Operator.ADD);
        assertThat(operators.get(1)).isEqualTo(Operator.MULTIPLY);
        assertThat(operators.get(2)).isEqualTo(Operator.DIVIDE);
    }


    @DisplayName("getNumberListWithoutInitialNumber() 테스트 케이스 : 실패 케이스 -> 계산식의 사칙연산을 제외한 값 가져올 때 숫자가 아닌 경우 에러")
    @Test
    void getNumberListWithoutInitialNumber1() {
        String input = "1 + & * 7 / 2";
        String[] expression = CalculatorParser.parseExpression(input);

        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            CalculatorParser.getNumberListWithoutInitialNumber(expression);
        });
    }

    @DisplayName("getNumberListWithoutInitialNumber() 테스트 케이스 : 성공 케이스 -> 계산식의 사칙연산과 초기값을 제외한 숫자값 가져오기")
    @Test
    void getNumberListWithoutInitialNumber2() {
        String input = "1 + 7 * 7 / 2";
        String[] expression = CalculatorParser.parseExpression(input);

        List<Integer> numbers = CalculatorParser.getNumberListWithoutInitialNumber(expression);

        assertThat(numbers.get(0)).isEqualTo(7);
        assertThat(numbers.get(1)).isEqualTo(7);
        assertThat(numbers.get(2)).isEqualTo(2);
    }


    @DisplayName("getNumberListWithoutInitialNumber() 테스트 케이스 : operators, numbers 사이즈가 다르다면 수식이 잘못되었으므로 에러처리")
    @Test
    void validate() {
        String input = "1 + 7 * 7 / * 2 ";
        String[] expression = CalculatorParser.parseExpression(input);

        List<Operator> operators = CalculatorParser.getOperatorList(expression);
        List<Integer> numbers = CalculatorParser.getNumberListWithoutInitialNumber(expression);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            CalculatorParser.validate(operators, numbers);
        });
    }
}
