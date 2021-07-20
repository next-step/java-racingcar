package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    @DisplayName("인스턴스가_정상적으로_생성되는지_확인한다")
    void createInstance() throws Exception {
        Calculator actual = Calculator.from("2 + 3 * 4 / 2");
        assertThat(actual).isInstanceOf(Calculator.class);
    }

    @Test
    @DisplayName("인스턴스가_정상적으로_예외를_던지는지_확인한다")
    void createException() throws Exception {
        assertThatThrownBy(() -> Calculator.from("3 + 2 * 4 / +"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자와 사칙 연산자만 입력 가능하며, 모든 글자 사이에는 공백이 존재해야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10",
                        "9 / 5 * 6 + 2:8",
                        "7 * 3 / 2 + 3:13"},
               delimiter = ':')
    @DisplayName("계산기가_정상적인_결과를_반환하는지_확인한다")
    void calculate(String condition, int expected) throws Exception {
        int actual = Calculator.from(condition).calculate();
        assertThat(actual).isEqualTo(expected);
    }
}
