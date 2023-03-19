package study;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.StringCalcurator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalcuratorTest {

    StringCalcurator calcurator = new StringCalcurator();

    @DisplayName("문자열 계산기 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "2 + 3 * 4 / 2 - 3", "2 + 1", "6 / 7 + 2" })
    void test(String input) {

        int result = calcurator.calc(input);
        System.out.println(result);
    }

    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    void spaceOrNullInputTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            calcurator.calc(input);
        }).withMessageMatching("입력값이 null이거나 빈 공백 문자입니다.");
    }

    @DisplayName("연산자는 덧셈 뺄셈 곱셉 나눗셈만 입력 가능 합니다.")
    @ParameterizedTest
    @ValueSource(strings = { "2 @ 2", "4 + 2 $ 1" })
    void invalidSignInputTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            calcurator.calc(input);
        }).withMessageMatching("연산자는 덧셈 뺄셈 곱셉 나눗셈만 입력 가능 합니다.");
    }

    @DisplayName("숫자와 연산자의 개수가 맞지 않습니다.")
    @ParameterizedTest
    @ValueSource(strings = { "2 + 2 + 2 2", "4 + - 2 * 1" })
    void invalidNumberAndSignInputTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            calcurator.calc(input);
        }).withMessageMatching("숫자와 연산자의 개수가 맞지 않습니다.");
    }

    @DisplayName("숫자는 최소 2개 이상이어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = { "2" })
    void invalidNumberInputTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            calcurator.calc(input);
        }).withMessageMatching("숫자는 최소 2개 이상이어야 합니다.");
    }

}
