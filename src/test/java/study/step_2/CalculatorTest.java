package study.step_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step_1.domain.Calculator;
import study.step_1.service.AddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static study.step_1.domain.Calculator.INVALID_INPUT_VALUE;

public class CalculatorTest {

    private static final String BLANK = "";
    private static final String BLANK_STRING = "    ";

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
