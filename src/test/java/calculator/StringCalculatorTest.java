package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("음수 예외")
    void test5() {
        assertThatThrownBy(
                () -> StringCalculator.cal("-2,3")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 하나일때 숫자반환")
    void test4() {
        int result = StringCalculator.cal("23");
        assertThat(result).isEqualTo(23);
    }
    @Test
    @DisplayName("커스텀 구분자")
    void test3() {
        int result = StringCalculator.cal("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론 구분자")
    void test2() {
        int result = StringCalculator.cal("1:2");
        assertThat(result).isEqualTo(3);
    }
    @Test
    @DisplayName("쉼표 구분자")
    void test1() {
        int result = StringCalculator.cal("1,2");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("빈 문자열, null 테스트")
    void null_empty_test(String input) {
        int result = StringCalculator.cal(input);
        assertThat(result).isEqualTo(0);
    }
}
