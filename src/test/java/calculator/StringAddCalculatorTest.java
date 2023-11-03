package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null을 전달하는 경우 0을 반환")
    void 빈문자_null_check() {

        int result = splitAndSum("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자하나를 문자열로 전달하는 경우 숫자의 합을 반환")
    void 숫자하나_split() {

        int result = splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표(,)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    void 쉼표구분자_split() {

        int result = splitAndSum("1,2,3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    void 콜론구분자_split() {

        int result = splitAndSum("1:2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    void 콜론과쉼표_구분자_split() {

        int result = splitAndSum("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    void 커스텀구분자_split() {

        int result = splitAndSum("//;\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 throw")
    void split_Exception() {
        assertThatThrownBy(() -> splitAndSum("pp")).isInstanceOf(RuntimeException.class);
    }


}
