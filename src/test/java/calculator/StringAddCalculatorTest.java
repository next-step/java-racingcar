package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("splitAndSum 메소드는 null 또는 빈문자가 입력 되었을때, 결과값은 '0'이 나와야 한다.")
    @Test
    public void splitAndSum_메소드_입력값_검증_테스트() {
        int expected = StringAddCalculator.splitAndSum(null);
        assertThat(expected).isEqualTo(0);

        expected = StringAddCalculator.splitAndSum("");
        assertThat(expected).isEqualTo(0);
    }

    @DisplayName("splitAndSum 메소드는 숫자 문자 하나가 입력 되었을때, 결과값은 Integer로 변경 후 리턴해야 한다.")
    @Test
    public void splitAndSum_메소드_입력값_검증_테스트_2() {
        int expected = StringAddCalculator.splitAndSum("1");
        assertThat(expected).isEqualTo(1);
    }

    @DisplayName("splitAndSum 메소드는 문자열이 ', or :' 로 구분되어 입력 되었을때, 숫자의 합을 반환해야 한다.")
    @Test
    public void splitAndSum_메소드_덧셈_테스트() {
        int expected = StringAddCalculator.splitAndSum("1,2");
        assertThat(expected).isEqualTo(3);

        expected = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(expected).isEqualTo(6);
    }

    @DisplayName("splitAndSum 메소드는 문자열이 '//(구분자)\n(숫자)(구분자)(숫자)(구분자)(숫자)~~' 와 같은 구조로 입력 되었을때, 숫자의 합을 반환해야 한다.")
    @Test
    public void splitAndSum_메소드_덧셈_테스트_2() {
        int expected = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(expected).isEqualTo(6);
    }

    @DisplayName("splitAndSum 메소드는 입력 문자열에 음수가 포함 되었을때, RuntimeException 예외가 반환되어야 한다.")
    @Test
    public void splitAndSum_메소드_음수_예외_테스트() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
