import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    void splitAndSum_빈_문자열_또는_null_전달() {
        assertThat(stringAddCalculator.splitAndSum("")).isEqualTo(0);

        assertThat(stringAddCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자_하나_전달() {
        int value = stringAddCalculator.splitAndSum("2");
        assertThat(value).isEqualTo(2);
    }

    @Test
    void splitAndSum_숫자_여러개_콤마로_구분() {
        int value = stringAddCalculator.splitAndSum("0,1,2,3");
        assertThat(value).isEqualTo(6);
    }

    @Test
    void splitAndSum_숫자_여러개_콤마와_콜론으로_구분() {
        int value = stringAddCalculator.splitAndSum("0:1,2:3");
        assertThat(value).isEqualTo(6);
    }

    @Test
    void splitAndSum_커스텀_구분자로_구분() {
        int value = stringAddCalculator.splitAndSum("//;\n0;1;2;3");
        assertThat(value).isEqualTo(6);
    }

    @Test
    void splitAndSum_음수_전달_시_RuntimeException_발생() {
        assertThatThrownBy(() -> {
            int value = stringAddCalculator.splitAndSum("//;\n0;-1;2;3");
        }).isInstanceOf(RuntimeException.class).hasMessage("음수를 입력할 수 없습니다.");
    }
}