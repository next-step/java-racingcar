package caculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    public void testNullOrEmptyCase(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    public void testSingleNumberCase() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Nested
    @DisplayName("구분자 테스트")
    class DelimiterTest {
        @Test
        @DisplayName("숫자들을 컴마(,) 구분자로 입력할 경우 모든 숫자들의 합을 반환한다.")
        public void testCommaDelimiter(String input, int expected) {
            int result = StringAddCalculator.splitAndSum(input);
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("숫자들을 콜론(:) 구분자로 입력할 경우 모든 숫자들의 합을 반환한다.")
        public void testColonDelimiter() {
            int result = StringAddCalculator.splitAndSum("1:2");
            assertThat(result).isEqualTo(3);
        }

        @Test
        @DisplayName("숫자들을 컴마(,) 또는 콜론(:) 구분자로 입력할 경우 모든 숫자들의 합을 반환한다.")
        public void testColonOrCommaDelimiter() {
            int result = StringAddCalculator.splitAndSum("1,2:3");
            assertThat(result).isEqualTo(6);
        }

        @Test
        @DisplayName("숫자들을 “//”와 “\n” 문자 사이에 지저된 커스텀 구분자로 입력할 경우 모든 숫자들을 합을 반환한다.")
        public void testCustomDelimiter() {
            int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
            assertThat(result).isEqualTo(6);
        }
    }

    @Test
    @DisplayName("음수를 입력하는 경우 RuntimeException이 발생한다.")
    public void testNegativeNumberCase() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}