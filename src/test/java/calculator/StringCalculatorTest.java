package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("숫자 이외의 값을 입력할 경우 예외발생")
    @ValueSource(strings = {"a,2,3", "$,1", "ㅁ,3", "a"})
    void notNumber_exception_test(String input) {
        assertThatThrownBy(() -> splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수를 입력할 경우 예외발생")
    void negativeNumber_exception_test() {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("커스텀 구분자를 입력할 경우 입력된 숫자들의 합을 반환")
    void splitAndSum_customDelimiter_test() {
        int actual = splitAndSum("//;\n1:2:4");
        assertThat(actual).isEqualTo(7);

        actual = splitAndSum("//@\n2@3:4,1");
        assertThat(actual).isEqualTo(10);
    }

    @Test
    @DisplayName("콜론(:)를 구분자로 입력할 경우 입력된 숫자들의 합을 반환")
    void splitAndSum_colonDelimiter_test() {
        int actual = splitAndSum("1,2:4");
        assertThat(actual).isEqualTo(7);

        actual = splitAndSum("2:3:4");
        assertThat(actual).isEqualTo(9);
    }

    @Test
    @DisplayName("콤마(,)를 구분자로 입력할 경우 입력된 숫자들의 합을 반환")
    void splitAndSum_commaDelimiter_test() {
        int actual = splitAndSum("1,2");
        assertThat(actual).isEqualTo(3);

        actual = splitAndSum("2,3,4");
        assertThat(actual).isEqualTo(9);
    }

    @Test
    @DisplayName("단일 숫자는 해당 숫자 그대로 반환")
    void splitAndSum_singleNumber_test() {
        int actual = splitAndSum("1");
        assertThat(actual).isEqualTo(1);

        actual = splitAndSum("10");
        assertThat(actual).isEqualTo(10);
    }

    @Test
    @DisplayName("빈 문자열, null 체크 테스트")
    void splitAndSum_emptyString_null_test() {
        int actual = splitAndSum("");
        assertThat(actual).isEqualTo(0);

        actual = splitAndSum(null);
        assertThat(actual).isEqualTo(0);
    }
}
