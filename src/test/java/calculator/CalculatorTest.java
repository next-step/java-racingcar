package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("계산기가 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw하는지 테스트")
    void checkInputNullOrEmptyString(String input) {
        Calculator calCulator = new Calculator();
        assertThatThrownBy(() -> {
            calCulator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
