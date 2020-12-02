package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("of method test")
    void ofTest() {
        Expression expression = new Expression("1 + 2");
        assertAll("expression",
                () -> assertEquals(expression.of(0), "1"),
                () -> assertEquals(expression.of(1), "+"),
                () -> assertEquals(expression.of(2), "2"));
    }

    @Test
    @DisplayName("식 길이 측정 test")
    void lengthTest() {
        Expression expression = new Expression("1 + 2");
        assertThat(expression.length()).isEqualTo(3);
    }

}
