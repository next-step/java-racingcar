import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    @DisplayName("null이 들어오면 0을 반환하는 테스트")
    void testNullCheck() {
        int result = StringAddCalculator.calculateSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈값이 들어오면 0을 반환하는 테스트")
    void testEmptyCheck() {
        int result = StringAddCalculator.calculateSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나가 들어오면 int 타입으로 반환하는 테스트")
    void testStringToInt() {
        int result = StringAddCalculator.calculateSum("5");
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName(",(컴마)와 :(콜론)과 커스텀 구분자를 입력할 경우 합을 반환하는 테스트")
    @CsvSource(value = {"5,6=11","5:6=11","5,6:7,8=26","5:6,7:8=26","5,6:7=18"}, delimiter = '=')
    void testNumCustomDelimiter(String input, int output) {
        int result = StringAddCalculator.calculateSum(input);
        assertThat(result).isEqualTo(output);
    }

    @Test
    @DisplayName("커스텀 구분자와 숫자 2개를 입력할 경우 두 숫자의 합을 반환하는 테스트")
    void testSplitByCustomDelimiter() {
        int result = StringAddCalculator.calculateSum("//;\n5;6");
        assertThat(result).isEqualTo(11);
    }

    @Test
    @DisplayName("커스텀 구분자를 잘 못 입력할 경우 테스트")
    void testWrongDelimiter() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            StringAddCalculator.calculateSum("//;n5;6");
        });
    }

    @Test
    @DisplayName("음수를 입력할 경우 테스트")
    void testNegativeNumber() {
        assertThatThrownBy(() -> StringAddCalculator.calculateSum("-1:6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력해주세요.");
    }
}