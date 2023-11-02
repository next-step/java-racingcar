package calculator;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @Test
    void 빈_문자열_또는_null_값인_경우_0을_반환한다() {
        int expected = 0;
        Assertions.assertAll(
            () -> {
                int actual = splitAndSum(null);

                assertThat(actual).isEqualTo(expected);
            },
            () -> {
                int actual = splitAndSum("");

                assertThat(actual).isEqualTo(0);
            }
        );
    }

    @Test
    void 숫자가_하나일_때_숫자_그대로의_값을_반환한다() {
        int actual = splitAndSum("1");
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 숫자_두개를_컴마_구분자로_입력_할_경우_두_숫자의_합을_반환한다() {
        int actual = splitAndSum("1,2,3");
        int expected = 6;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 구분자를_컴마_외에_콜론을_사용하여_합을_반환한다() {
        int actual = splitAndSum("1:2:3");
        int expected = 6;

        assertThat(actual).isEqualTo(expected);
    }

}
