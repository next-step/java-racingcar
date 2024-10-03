package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSumCalculatorTest {

    @Test
    @DisplayName("빈 문자, null, 구분자만 있을 경우 0을 반환한다.")
    void testSumStringWithEmpty() {
        int result = StringSumCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = StringSumCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringSumCalculator.splitAndSum(",");
        assertThat(result).isEqualTo(0);

        result = StringSumCalculator.splitAndSum(":");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("기본 구분자(쉼표, 콜론) 를 기준으로 분리한 각 숫자의 합을 반환")
    void testSumStringWithDefaultDelimiter() {

        int result = StringSumCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);

        result = StringSumCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);

        result = StringSumCalculator.splitAndSum("1,2,3");
        assertThat(result).isEqualTo(6);

        result = StringSumCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 를 기준으로 분리한 각 숫자의 합을 반환")
    void testSumStringWithCustomDelimiter() {
        int result = StringSumCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);

    }

    @Test
    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
    void testThrowExceptionWithMinusNumber() {
        assertThatThrownBy(() -> {
            StringSumCalculator.splitAndSum("-1,1:1");
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            StringSumCalculator.splitAndSum("*,A,1:1");
        }).isInstanceOf(RuntimeException.class);
    }
}
