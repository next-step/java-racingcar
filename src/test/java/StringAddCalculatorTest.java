import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import utils.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Nested
    class SplitAndSumTest {

        @ParameterizedTest
        @NullAndEmptySource
        public void nullOrEmptyTest(String input) {
            int result = StringAddCalculator.splitAndSum(input);
            assertThat(result).isEqualTo(0);
        }

        @Test
        public void singleNumberTest() {
            int result = StringAddCalculator.splitAndSum("1");
            assertThat(result).isEqualTo(1);
        }

        @Test
        public void commaDelimiterTest() {
            int result = StringAddCalculator.splitAndSum("1,2");
            assertThat(result).isEqualTo(3);
        }

        @Test
        public void commaOrColonTest() {
            int result = StringAddCalculator.splitAndSum("1,2:3");
            assertThat(result).isEqualTo(6);
        }

        @Test
        public void customDelimiterTest() {
            int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
            assertThat(result).isEqualTo(6);
        }

        @Test
        public void negativeNumberTest() {
            assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
        }
    }
}
