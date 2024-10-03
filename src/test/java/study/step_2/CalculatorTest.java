package study.step_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step_2.domain.Calculator;
import study.step_2.service.AddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static study.step_2.domain.Calculator.INVALID_INPUT_VALUE;

public class CalculatorTest {

    private static final String BLANK = "";
    private static final String BLANK_STRING = "    ";

    @DisplayName(", 혹은 : 구분자와 하나 이상의 숫자를 포함하는 문자열을 전달 받았을 경우 구분자를 기준으로 분리한 각 숫자의 합을 정수형으로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2 3", "1,2,3 6", "1:2:3 6", "1:2,4 7", "1, 1", "1: 1", ":1 1", ",1 1"}, delimiter = ' ')
    public void splitAndSum(String input, String expectResult) {
        AddCalculator calculator = new AddCalculator(new Calculator(input));
        assertThat(calculator.executeAdd(input)).isEqualTo(Integer.parseInt(expectResult));
    }

    @DisplayName(", 혹은 : 구분자와 하나의 숫자를 포함하는 문자열을 전달 받았을 경우에 구분자를 기준으로 분리한 숫자를 정수형으로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 1", "1: 1", ":1 1", ",1 1"}, delimiter = ' ')
    public void splitAndSum_단일문자를_입력받을떄(String input, String expectResult) {
        AddCalculator calculator = new AddCalculator(new Calculator(input));
        assertThat(calculator.executeAdd(input)).isEqualTo(Integer.parseInt(expectResult));
    }

    @DisplayName(", 혹은 : 구분자와 하나 이상의 숫자를 포함하지 않는 문자열을 전달 받았으면 0을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {", 0", ": 0"}, delimiter = ' ')
    public void splitAndSum_숫자를_입력받지_못했을때(String input, String expectResult) {
        AddCalculator calculator = new AddCalculator(new Calculator(input));
        assertThat(calculator.executeAdd(input)).isEqualTo(Integer.parseInt(expectResult));
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @NullSource
    @ParameterizedTest
    @ValueSource(strings = {BLANK, BLANK_STRING})
    public void splitAndSum_빈_문자열_또는_null값을_입력할_경우(String input) {
        AddCalculator calculator = new AddCalculator(new Calculator(input));
        assertThat(calculator.executeAdd(input)).isEqualTo(INVALID_INPUT_VALUE);
    }

    @DisplayName("음수가 들어올 경우 예외를 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12:-1", "-12:1", "-1,-3"})
    public void splitAndSum_음수가_들어올_경우_예외를_처리한다(String input) {
        assertThatThrownBy(() -> new Calculator(input)).isInstanceOf(RuntimeException.class);
    }
}
