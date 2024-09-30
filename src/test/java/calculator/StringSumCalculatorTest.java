package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSumCalculatorTest {

    @Test
    void null_또는_빈문자열() {
        int result = StringSumCalculator.sum("");
        assertThat(result).isEqualTo(0);

        result = StringSumCalculator.sum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        int result = StringSumCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }
}
