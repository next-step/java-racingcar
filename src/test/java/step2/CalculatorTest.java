package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest(name = "{0}구분자로 나눈 후 덧셈")
    @ValueSource(strings = {"1,2,3", "1:2:3"})
    void splitTest(String str) {
        int result = Calculator.splitCalculator(str);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest(name = "공백의 경우 result = 0")
    @ValueSource(strings = {"", " "})
    void blankTest(String str) {
        int result = Calculator.splitCalculator(str);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("null의 경우 result = 0")
    void nullTest() {
        int result = Calculator.splitCalculator(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("커스텀 구분자")
    void customTest() {
        String str = "//;\\n1;2;3";

        int result = Calculator.splitCalculator(str);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest(name = "RuntimeException 테스트")
    @ValueSource(strings = {"1,2,-3", "w, a, b"})
    void runtimeErrorTest(String str) {
        assertThatThrownBy(() -> {
            Calculator.splitCalculator(str);
        }).isInstanceOf(RuntimeException.class);

    }

}
