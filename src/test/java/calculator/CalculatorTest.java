package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    private Validator validator;
    private Calculator calculator;

    @BeforeEach
    void setUp() {

        validator = new Validator();
        calculator = new Calculator(validator);
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 - 3", "11 * 2 / 3"})
    @DisplayName("Tokenize")
    void tokenize(String input) {
        List<String> result = calculator.tokenize(input);

        assertThat(result.size()).isNotZero();
    }

    @Test
    @DisplayName("client에게 제공되는 public method calculate")
    void calculate() {

        assertThat(calculator.calculate("1 + 2 * 3")).isEqualTo(9);
        assertThat(calculator.calculate("1 + 1 * 0")).isEqualTo(0);
        assertThat(calculator.calculate("1 + 4 * 3")).isEqualTo(15);
        assertThat(calculator.calculate("2 * 3")).isEqualTo(6);

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("2 *"));

    }

}