package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 빈_문자열() {
        int nullResult = StringCalculator.splitAndSum(null);
        assertThat(nullResult).isEqualTo(0);

        int emptyResult = StringCalculator.splitAndSum("");
        assertThat(emptyResult).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        int singleNumberResult = StringCalculator.splitAndSum("1");
        assertThat(singleNumberResult).isEqualTo(1);
    }
}
