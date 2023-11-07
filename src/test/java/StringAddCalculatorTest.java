import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    @DisplayName("빈값 또는 null 전달")
    void stringAddCalculator_With_빈값_또는_null() {
        assertThat(stringAddCalculator.splitAndSum("")).isEqualTo(0);

        assertThat(stringAddCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 전달")
    void stringAddCalculator_With_숫자_하나_전달() {
        int value = stringAddCalculator.splitAndSum("2");
        assertThat(value).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자 여러개를 콤마로 구분해서 전달")
    void stringAddCalculator_With_숫자_여러개_콤마로_구분() {
        int value = stringAddCalculator.splitAndSum("0,1,2,3");
        assertThat(value).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 여러개를 콤마와 콜론으로 구분해서 전달")
    void stringAddCalculator_With_숫자_여러개_콤마와_콜론으로_구분() {
        int value = stringAddCalculator.splitAndSum("0:1,2:3");
        assertThat(value).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분해서 전달")
    void stringAddCalculator_With_커스텀_구분자로_구분() {
        int value = stringAddCalculator.splitAndSum("//;\n0;1;2;3");
        assertThat(value).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 전달")
    void stringAddCalculator_With_음수_전달() {
        assertThatThrownBy(() -> {
            int value = stringAddCalculator.splitAndSum("//;\n0;-1;2;3");
        }).isInstanceOf(RuntimeException.class).hasMessage("음수를 입력할 수 없습니다.");
    }
}