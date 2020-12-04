package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 5 - 2 * 10 / 2:9",
            "10 * 5 + 3 - 4:7",
            "8 - 3:3",
            "9 / 3 + 10 - 2 * 1:9",
            "1 + 2 + 45 - 45 - 80 / 1 / 1 / 1 * 2 * 10:19"}, delimiter = ':')
    @DisplayName("사칙연산 문자열 분해 테스트")
    void splitStringTest(String input, int expected) {
        String[] result = calculator.splitStringByBlankValue(input);

        assertThat(result.length).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "9", "10", "55", "100"})
    @DisplayName("숫자 검증 통과 테스트")
    void numberPassTest(String input) {
        assertThat(calculator.isNumber(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "오", "*", "십7", "-", "/"})
    @DisplayName("숫자 검증 실패 테스트")
    void numberFailTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.isNumber(input))
                .withMessageMatching("숫자가 아닙니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "*", "-", "/"})
    @DisplayName("사칙연산 기호 검증 통과 테스트")
    void operationPassTest(String input) {
        assertThat(calculator.isOperation(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "$", "101", "%"})
    @DisplayName("사칙연산 기호 검증 실패 테스트")
    void operationFailTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.isOperation(input))
                .withMessageMatching("사칙연산 기호가 아닙니다");
    }

    @Test
    @DisplayName("사칙연산 기호와 숫자 자료구조 구축 테스트")
    void setUpNumbersAndOperationsTest() {
        // given
        String[] result = calculator.splitStringByBlankValue("1 + 2 + 45 - 45 - 80 / 2 / 1 / 1 * 2 * 10");

        // when
        calculator.setUpNumbersAndOperations(result);

        // then
        assertThat(calculator.numbers.size()).isEqualTo(10);
        assertThat(calculator.operations.size()).isEqualTo(9);
    }

    @Test
    @DisplayName("최종 값 테스트")
    void calculateNumberTest() {
        // given
        String[] result = calculator.splitStringByBlankValue("1 * 80 + 5 / 5 * 2 - 3");
        calculator.setUpNumbersAndOperations(result);

        // when
        calculator.calculateNumber();

        // then
        assertThat(calculator.numbers.size()).isEqualTo(1);
        assertThat(calculator.numbers.peek()).isEqualTo(31);
    }

    @Test
    @DisplayName("문자열 사칙연산 수행 테스트")
    void calculateTest() {
        assertThat(calculator.calculate("1 * 2 / 2 + 5 - 1")).isEqualTo(5);
    }
}
