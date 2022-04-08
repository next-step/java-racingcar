package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_이거나_null_인경우_숫자합계_반환(String str) {
        System.out.println("str = " + str);
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 쉼표를_기준으로_문자열_분리하여_합계_반환() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 콜론을_기준으로_문자열_분리하여_합계_반환() {
        int result = StringAddCalculator.splitAndSum("2:3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 쉼표와_콜론_기준으로_문자열_분리하여_합계_반환() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }
}
