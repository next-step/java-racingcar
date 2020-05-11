package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void validateIsNull(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.run(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 & 2"})
    @DisplayName("사칙연산 기호가 아닌 경우")
    void validateCalc(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.run(input));
    }

    @ParameterizedTest
    @CsvSource(value={"2 + 3,5","5 * 4,20","20 / 2,10"})
    @DisplayName("사칙연산 동작 확인")
    void calc(String input, int expected) {
        int result = StringCalculator.run(input);
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource(value={"2 + 3 * 4 / 2,10"})
    void run(String input,int expected) {
        int result = StringCalculator.run(input);
        assertEquals(expected,result);
    }
}