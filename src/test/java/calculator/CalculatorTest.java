package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값 입력시 0 출력 테스트")
    @NullAndEmptySource
    void null_또는_빈문자(String text) {
        int result = Calculator.calculate(text);
        assertThat(result).isEqualTo(0);
    }
}