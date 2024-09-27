package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAdditionCalculatorTest {

    @DisplayName("쉼표를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 잘 반환하는지")
    @Test
    void calculateTest_withComma() {
        assertThat(StringAdditionCalculator.calculate("1,2")).isEqualTo(3);
    }

    @DisplayName("콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 잘 반환하는지")
    @Test
    void calculateTest_withColon() {
        assertThat(StringAdditionCalculator.calculate("2:5")).isEqualTo(7);
    }

    @DisplayName("콜론과 쉼표를 모두 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 잘 반환하는지")
    @Test
    void calculateTest_withCommaAndColon() {
        assertThat(StringAdditionCalculator.calculate("1,2:3")).isEqualTo(6);
    }

}
