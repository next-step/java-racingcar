package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void separatingValueFromTheOperatorTest(String input) {
      stringCalculator.separatingValueFromTheOperator(input);
      assertThat(stringCalculator.getIntValues()).contains(2, 3, 4, 2);
      assertThat(stringCalculator.getOperators()).contains("+","*", "/");
    }
}