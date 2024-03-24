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
        assertThat(splitAndSum("2,4")).isEqualTo(6);
        assertThat(splitAndSum("10,4")).isEqualTo(14);
    }
}