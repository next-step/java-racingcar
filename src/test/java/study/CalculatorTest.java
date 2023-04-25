package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void 쉼표_구분자_테스트() {
        String sample = "1,2,3";
        int result = StringNumberCalculator.sumPatternString(sample);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 쉼표_구분자_테스트에_빈_문자열을_넣으면_결과_0() {
        String sample = "";
        int result = StringNumberCalculator.sumPatternString(sample);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 널_테스트() {
        String sample = null;
        int result = StringNumberCalculator.sumPatternString(sample);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 구분자_콜론_테스트() {
        String sample = "1:2:3:4:5";
        int result = StringNumberCalculator.sumPatternString(sample);
        assertThat(result).isEqualTo(15);
    }

    @Test
    void 혼합_테스트() {
        String sample = "1,2:3";
        int result = StringNumberCalculator.sumPatternString(sample);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        String sample = "//b\n1b2b3";
        int result = StringNumberCalculator.sumPatternString(sample);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수일경우_예외처리() {
        String sample = "-1:2:3";

        assertThatThrownBy(() -> {
            StringNumberCalculator.sumPatternString(sample);
        }).isInstanceOf(RuntimeException.class);
    }
}
