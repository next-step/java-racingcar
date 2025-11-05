package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.StringCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("입력 값이 null 또는 빈 문자열이면 0을 반환한다")
    @Test
    void nullOrEmpty() {
        int result = StringCalculator.calculate(null);
        Assertions.assertThat(result).isEqualTo(0);

        result = StringCalculator.calculate("");
        Assertions.assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나만 입력하면 해당 숫자를 반환한다")
    @Test
    void singleNumber() {
        int result = StringCalculator.calculate("1");
        Assertions.assertThat(result).isEqualTo(1);
    }

    @DisplayName("구분자를 추가하여 입력한 수를 더한다")
    @Test
    void singleSplit() {
        int result = StringCalculator.calculate("1,2");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자를 추가하여 입력한 수를 더한다")
    @Test
    void split() {
        int result = StringCalculator.calculate("1,2:3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자를 지정하여 숫자를 더한다")
    @Test
    void customSplit() {
        int result = StringCalculator.calculate("//;\n1;2;3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수를 입력하면 RuntimeException이 발생한다")
    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
