package calculator.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PolynomialParsingUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = {""
            , " "
            , "     "})
    void 수식이_비어있는_경우_예외가_발생한다(String expression) {
        assertThatThrownBy(() -> {
            PolynomialParsingUtils.isEmpty(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수식이_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> {
            PolynomialParsingUtils.isEmpty(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"123, 123"
            , "43, 43"
            , "-10, -10"
    })
    void 문자열형식의_숫자를_정수형으로_변환한다(String number, int expectedNumber) {
        assertThat(PolynomialParsingUtils.convertToNumber(number)).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test"
            , "+"
            , "     "
            , " "
            , "d"
            , "123+"
            , "1a2"})
    void 변환하려는_문자열이_숫자가아니면_예외를_발생한다(String string) {
        assertThatThrownBy(() -> {
            PolynomialParsingUtils.convertToNumber(string);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 수식이 수식 표현 규약에 어긋납니다.");
    }
}