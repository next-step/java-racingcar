package util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringCalculatorTest {
    @Test
    public void 문자열_덧셈_숫자() {
        String firstCase = "1,2,3";
        String secondCase = "4:5";

        long firstExpected = 6;
        long secondExpected = 9;

        assertAll(
                () -> assertThat(StringCalculator.addStringNumber(firstCase)).isEqualTo(firstExpected),
                () -> assertThat(StringCalculator.addStringNumber(secondCase)).isEqualTo(secondExpected)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void 문자열_덧셈_null_또는_빈문자(String input) {
        long expected = 0;

        assertThat(StringCalculator.addStringNumber(input)).isEqualTo(expected);
    }

    @Test
    public void 문자열_덧셈_문자() {
        String character = "a:b:c:1:2";

        assertThatThrownBy(() -> StringCalculator.addStringNumber(character)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 문자열_덧셈_음수() {
        String negative = "-1,2";

        assertThatThrownBy(() -> StringCalculator.addStringNumber(negative)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 문자열_덧셈_쉼표_또는_콜론() {
        String firstCase = "1,2,3:4";

        long expected = 10;

        assertThat(StringCalculator.addStringNumber(firstCase)).isEqualTo(expected);
    }

    @Test
    public void 문자열_덧셈_커스텀_구분자() {
        String firstCase = "//;\n1;2;3";

        long expected = 6;

        assertThat(StringCalculator.addStringNumber(firstCase)).isEqualTo(expected);
    }
}