package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest{

    private StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 빈_문자열_and_null_is_0_return() {
        int result = stringCalculator.isEmptyOrNull("");
        assertThat(result).isEqualTo(0);

        result = stringCalculator.isEmptyOrNull(null);
        assertThat(result).isEqualTo(0);
    }
}
