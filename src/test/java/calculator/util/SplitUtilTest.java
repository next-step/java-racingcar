package calculator.util;

import calculator.exception.NegativeNumberException;
import calculator.exception.NotANumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitUtilTest {

    @ParameterizedTest(name = ", 혹은 : 을 포함한 문자열 {0} 이 오면 숫자 배열 {1} 로 분리한다.")
    @CsvSource(value = {
            "|0", "''|0",
            "0|0", "1|1",
            "1,2|1,2", "1:2|1,2",
            "1,2,3|1,2,3", "1:2,3|1,2,3", "1,2:3|1,2,3", "1:2:3|1,2,3",
    }, delimiter = '|')
    void commaOrSemiColonSplit(String input, String results) {
        List<Integer> actual = SplitUtil.ints(input);
        List<Integer> expected = expectedResults(results);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("//와 \n 사이 문자 를 포함한 문자열이 오면 숫자 배열로 분리한다.")
    void customSplit() {
        List<Integer> actual = SplitUtil.ints("//_\n1_2_3");
        List<Integer> expected = List.of(1, 2, 3);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} 을 전달하는 경우 NegativeNumberException 예외를 throw 한다.")
    @ValueSource(strings = {
            "-1,1,2", "-1:1,2", "-1,1:2", "-1:1:2",
    })
    void negativeNumberSplitError(String input) {
        assertThatThrownBy(() -> SplitUtil.ints(input))
                .isInstanceOf(NegativeNumberException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "{0} 을 전달하는 경우 NotANumberException 예외를 throw 한다.")
    @ValueSource(strings = {
            "a,1,2", "a:1,2", "a,1:2", "a;1:2",
    })
    void notNumberSplitError(String input) {
        assertThatThrownBy(() -> SplitUtil.ints(input))
                .isInstanceOf(NotANumberException.class)
                .hasMessageContaining("숫자가 아닌 문자는 입력할 수 없습니다.");
    }

    private static List<Integer> expectedResults(String results) {
        return Arrays.stream(results.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
