package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest
    @DisplayName("Number Class를 이용한 사칙연산")
    @CsvSource(value = {"3 - 2:1", "3 - 2:1", "3 * 2:6", "4 / 2:2"}, delimiter = ':')
    void calculation(String expression, int result) {
        int acc = Calculator.calculate(expression);
        assertThat(acc).isEqualTo(result);
    }


    @Test
    @DisplayName("분모가 0일 경우 나눗셈 테스트")
    void dividedByZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int acc = Calculator.calculate("4 / 0");
        }).withMessageMatching("분모는 0이 될 수 없습니다.");
    }
}
