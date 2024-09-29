package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StringAddCalculatorTest {

    @DisplayName("입력 값이 0 또는 null인 경우 합은 0이다")
    @Test
    void emptyTextOrNull(){
        assertThat(splitAndSum("0")).isZero();
        assertThat(splitAndSum(null)).isZero();
    }

    @DisplayName(",을 구분자로 문자열을 쪼개서 합을 구한다")
    @Test
    void splitAndSumByComma(){
        assertThat(splitAndSum("1,2,3")).isEqualTo(6);
    }

    @DisplayName(":을 구분자로 문자열을 쪼개서 합을 구한다")
    @Test
    void splitAndSumByColon(){
        assertThat(splitAndSum("1:2:3")).isEqualTo(6);
    }

    @DisplayName(", : 구분자로 문자열을 쪼개서 합을 구한다")
    @Test
    void splitAndSumByCommaAndColon(){
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("// \n 사이의 커스텀 구분자로 문자열을 쪼개서 합을 구한다")
    @Test
    void splitAndSumByCustomDelimiter(){
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("음수를 입력하면 예외가 발생한다")
    @Test
    void splitAndSumByNegative(){
        assertThatThrownBy(() -> splitAndSum("-100,2:3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자형숫자가 아닌 값을 입력하면 예외가 발생한다")
    @Test
    void splitAndSumByNonNumber(){
        assertThatThrownBy(() -> splitAndSum("문자형숫자아님,2:3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}