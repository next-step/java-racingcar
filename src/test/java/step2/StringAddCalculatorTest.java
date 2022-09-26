package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void splitAndSum(String text) {
        Positive result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(Positive.ZERO);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum2() {
        Positive result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(new Positive(1));
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void splitAndSum3() {
        Positive result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(new Positive(3));
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void splitAndSum4() {
        Positive result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(new Positive(6));
    }

    @Test
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void splitAndSum5() {
        Positive result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(new Positive(6));
    }

    @Test
    @DisplayName("음수를 전달할 경우 Exception 예외가 발생해야 한다.")
    void splitAndSum6() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .withMessageMatching("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void splitAndSum7() {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> StringAddCalculator.splitAndSum("1,2,3,a"));
    }
}
