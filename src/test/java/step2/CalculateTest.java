package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열이면 0 반환")
    void returnZeroOnNullOrEmpty(String input) {
        assertEquals(0, Calculate.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "42"})
    @DisplayName("요구2: 숫자 하나면 그대로 반환")
    void returnSingleNumber(String input) {
        int expected = Integer.parseInt(input);
        assertEquals(expected, Calculate.calculate(input));
    }

    @Test
    @DisplayName("요구3: 콤마(,) 구분자로 합산")
    void sumWithComma() {
        assertThat(Calculate.calculate("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("요구4: 콤마(,) + 콜론(:) 혼용 시 합산")
    void sumWithCommaAndColon() {
        assertThat(Calculate.calculate("1,2:3")).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "//;\n1;2;3",
        "//|\n4|5|6",
        "//#\n7#8#9"
    })
    @DisplayName("요구5: 커스텀 구분자 //X\\n 으로 숫자들 합산")
    void customDelimiter(String input) {
        String delimiter = input.substring(2, 3);
        String body = input.substring(input.indexOf('\n') + 1);

        int expected = 0;
        for (String v : body.split(delimiter)) {
            expected += Integer.parseInt(v);
        }

        assertThat(Calculate.calculate(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자 본문이 비어있으면 0")
    void customDelimiterEmptyBody() {
        assertThat(Calculate.calculate("//;\n")).isZero();
    }
    @ParameterizedTest
    @ValueSource(strings = {
        "-1",
        "-1,2",
        "1,-2:3",
        "//;\n1;-2;3"
    })
    @DisplayName("요구6: 음수 입력 시 RuntimeException 발생")
    void throwsOnNegative(String input) {
        assertThatThrownBy(() -> Calculate.calculate(input))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("negative");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1,a", "//;\n1;X;3"})
    @DisplayName("추가: 잘못된 숫자 형식 → NumberFormatException")
    void invalidNumberFormat(String input) {
        assertThatThrownBy(() -> Calculate.calculate(input))
            .isInstanceOf(NumberFormatException.class)
            .hasMessageContaining("invalid");
    }

    @Test
    @DisplayName("추가: 큰 수 더하기 (버그 탐지용)")
    void largeNumbers() {
        assertThat(Calculate.calculate("1000,2000")).isEqualTo(3000);
    }
}
