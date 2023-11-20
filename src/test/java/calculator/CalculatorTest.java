package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.separator.CustomSeparator;
import calculator.separator.DefaultSeparator;
import calculator.separator.Separator;
import calculator.separator.SimpleSeparator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = createCalculator();
    }

    private Calculator createCalculator() {
        return new Calculator(initSeparators());
    }

    private List<Separator> initSeparators() {
        List<Separator> separators = new ArrayList<>();
        separators.add(new DefaultSeparator());
        separators.add(new CustomSeparator());
        separators.add(new SimpleSeparator());
        return separators;
    }

    @Test
    @DisplayName("쉼표를 가지는 문자열을 전달한 경우 구분자를 기준으로 분리한 각 숫자의 합을 구함")
    void rest_sum() {
        // given
        String given = "1,3";

        // when
        PositiveNumber result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(new PositiveNumber("4"));
    }

    @Test
    @DisplayName("콜론을 가지는 문자열을 전달한 경우 구분자를 기준으로 분리한 각 숫자의 합을 구함")
    void column_sum() {
        // given
        String given = "1:3";

        // when
        PositiveNumber result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(new PositiveNumber("4"));
    }

    @Test
    @DisplayName("문자열 앞부분에 // 와 \n 사이의 문자를 커스텀 구분자로 사용한다.")
    void custom_regex_sum() {
        // given
        String given = "//&\n1&3";

        // when
        PositiveNumber result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(new PositiveNumber("4"));
    }

    @ParameterizedTest
    @DisplayName("빈 문자열이나 null이 주어지면 0을 반환한다.")
    @NullAndEmptySource
    void return_zero(String given) {
        // given

        // when
        PositiveNumber result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(new PositiveNumber("0"));
    }

    @ParameterizedTest
    @DisplayName("숫자 이외의 값이나 음수가 주어지면 예외를 반환한다.")
    @ValueSource(strings = {"-3:2", "숫자아님,숫자아니다", "//&\n-3&3", "//&\n숫자아니다&3"})
    void throw_exception(String given) {
        // given

        // when // then
        assertThatThrownBy(() -> calculator.calculate(given))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 하나를 입력한 경우 해당 숫자를 반환한다.")
    void simple_number() {
        // given
        String given = "4";

        // when
        PositiveNumber result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(new PositiveNumber("4"));
    }
}
