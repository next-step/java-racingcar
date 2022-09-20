package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자인_경우_0으로_반환함(final String str) {

        final int actual = StringAddCalculator.splitAndSum(str);

        assertThat(actual).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2", "3:3", "4:4", "5:5", "6:6", "7:7", "8:8", "9:9"}, delimiter = ':')
    void splitAndSum_문자열_숫자하나인_경우_숫자로_반환함(final String str, final int expect) {

        assertThat(StringAddCalculator.splitAndSum(str)).isEqualTo(expect);
    }

    @Test
    void splitAndSum_쉼표구분자로_자르고_합을_구함() {

        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자로_자르고_합을_구함() {

        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자로_자르고_합을_구함() {

        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_음수인_경우_익셉션_처리함() {

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 불가능합니다.");
    }

    @Test
    void splitAndSum_요구사항의_해당되지_않는_값을_입력한_경우_익셉션_처리함() {

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1P23s"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값을 잘못 입력하였습니다.");
    }
}
