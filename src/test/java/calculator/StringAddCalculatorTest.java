package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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
    @CsvSource(value = {"0,0", "1,1", "2,2", "3,3", "4,4", "5,5", "6,6", "7,7", "8,8", "9,9"})
    void splitAndSum_문자열_숫자하나인_경우_숫자로_반환함(final String str, final int expect) {

        assertThat(StringAddCalculator.splitAndSum(str)).isEqualTo(expect);
    }

    @Test
    void splitAndSum_문자열_하나인_경우_익셉션_처리함() {

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("provideStringFor")
    void splitAndSum_쉼표구분자_쉼표_콜론_커스텀_구분자로_자르고_합을_구함(final String str, final int expect) {

        assertThat(StringAddCalculator.splitAndSum(str)).isEqualTo(expect);
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

    private static Stream<Arguments> provideStringFor() {

        return Stream.of(
                Arguments.of("1,2", 3),
                Arguments.of("1,2:3", 6),
                Arguments.of("//;\n1;2;3", 6)
        );
    }
}
