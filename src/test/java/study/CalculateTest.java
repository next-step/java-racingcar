package study;

import com.process.CaculateProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculateTest {
    @DisplayName("입력 문자열 split 후 단위 계산 test")
    @ParameterizedTest
    @CsvSource(value = {"-,2", "+,6", "*,8", "/,2"})
    void subCalculate(String operator, int expected) {
        CaculateProcessor processor = new CaculateProcessor();
        Assertions.assertEquals(processor.subCalculate(4, operator, 2), expected);
    }

    @Test
    @DisplayName("입력 연산자가 정상적이지 않을 경우 IllegalArgumentException test")
    void subCalculateException() {
        CaculateProcessor processor = new CaculateProcessor();
        assertThatThrownBy(() -> processor.subCalculate(4, "?", 2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("연산자가 알맞지 않습니다");
    }

    @Test
    @DisplayName("입력 문자열 전체 계산 test")
    void calculate() {
        CaculateProcessor processor = new CaculateProcessor();
        assertThat(processor.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("입력 문자열이 정상적이지 않을 경우 IllegalArgumentException test")
    void calculateException() {
        CaculateProcessor processor = new CaculateProcessor();
        assertThatThrownBy(() -> processor.calculate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자열이 알맞지 않습니다");
    }
}
