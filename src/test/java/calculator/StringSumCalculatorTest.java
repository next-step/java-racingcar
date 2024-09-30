package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSumCalculatorTest {

    @Test
    void 숫자_하나() {
        int result = StringSumCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }
}
