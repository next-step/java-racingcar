package step2_string_add_calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step2_string_add_calc.StringAddCalculator.*;

class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다")
    void returnZero_emptyOrNullTest() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void returnInputWhen() {
        assertThat(splitAndSum("1")).isEqualTo(1);
        assertThat(splitAndSum("77")).isEqualTo(77);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void returnSum_InputTwoNumbersWithDelimiting() {
        // 앞 단계의 구분자가 없는 경우도 split()을 활용가능
        assertThat(splitAndSum("2,4")).isEqualTo(6);
        assertThat(splitAndSum("10,4")).isEqualTo(14);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void useDelimiterInsteadOfComma() {
        assertThat(splitAndSum("2,4")).isEqualTo(6);
        assertThat(splitAndSum("10:4")).isEqualTo(14);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    void useCustomDelimiterWithRegex() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

}