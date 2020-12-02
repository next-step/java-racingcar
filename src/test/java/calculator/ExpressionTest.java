package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExpressionTest {

    @Test
    @DisplayName("입력값 null test")
    void nullInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Expression expression = new Expression(null);
                }).withMessageMatching("input data is empty");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력값 공백 test")
    void emptyInputTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           Expression expression = new Expression(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력값 공백 test")
    void emptyInputTest2(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Expression expression = new Expression(input);
                }).withMessageMatching("input data is empty");
    }

}
