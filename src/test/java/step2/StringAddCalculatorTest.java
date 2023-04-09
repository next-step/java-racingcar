package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringAddCalculatorTest {
    StringAddCalculator s = new StringAddCalculator();

    @Test
    @DisplayName("빈 문자열이거나 null인 경우 0을 반환")
    void emptyOrNullCase() {
        assertThat(s.splitAndSum(null)).isEqualTo(0);
        assertThat(s.splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void oneStringCase() {
        String text = "1";
        assertThat(s.splitAndSum(text)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 구분자로 입력할 경우 두 숫자의 합을 반환")
    void twoStringCase() {
        String text = "1,2";
        assertThat(s.splitAndSum(text)).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마 이외에 콜론을 사용한 합을 반환")
    void delimitersCase() {
        String text = "1,2:3";
        assertThat(s.splitAndSum(text)).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 합을 반환")
    void customDelimiterCase() {
        String text = "//;\n2;3;4";
        assertThat(s.splitAndSum(text)).isEqualTo(9);
    }

    @Test
    @DisplayName("음수값 전달시 예외 발생")
    void negativeCase() {
        String text = "-1,2:3";
        assertThatThrownBy(() -> s.splitAndSum(text)).isInstanceOf(RuntimeException.class);
    }
}