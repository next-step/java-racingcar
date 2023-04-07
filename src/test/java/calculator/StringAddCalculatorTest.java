package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAddSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("문자열이 null 또는 비었을 경우 0을 리턴한다")
    void splitAndSum_null_또는_빈문자() {
      int result =  splitAddSum(null);

        assertThat(result).isEqualTo(0);

        result = splitAddSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환 한다.")
    void splitAndSum_숫자하나() {
        int result = splitAddSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개와 구분자(,)를 포함한 문자열을 입력할 경우 두 숫자의 합을 반환 한다.")
    void splitAndSum_숫자두개_컴마() {
        int result = splitAddSum("1,2");
        assertThat(result).isEqualTo(3);

    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = splitAddSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수일 경우 RuntimeException 발생")
    void splitAndSum_음수() {
        assertThatThrownBy(() -> splitAddSum("-1")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("문자 경우 RuntimeException 발생")
    void splitAndSum_문자() {
        assertThatThrownBy(() -> splitAddSum("숫자아님")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndSum_커스텀구분자() {
        int result = splitAddSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

}