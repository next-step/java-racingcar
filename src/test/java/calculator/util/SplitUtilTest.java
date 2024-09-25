package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitUtilTest {

    @ParameterizedTest
    @CsvSource(value = {
            ":0",
            "'':0",
            "1:1",
            "1,2:1,2",
            "1;2:1,2",
            "1,2,3:1,2,3",
            "1;2,3:1,2,3",
            "1,2;3:1,2,3",
            "1;2;3:1,2,3",
    }, delimiter = ':')
    @DisplayName("쉼표(,), 세미콜론(;) 을 포함한 문자열이 오면 숫자 배열로 분리한다.")
    void commaOrSemiColonSplit(String input, String results) {
        Integer[] actual = SplitUtil.integers(input);
        Integer[] expected = expectedResults(results);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("//와 \n 사이 문자 를 포함한 문자열이 오면 숫자 배열로 분리한다.")
    void customSplit() {
        Integer[] actual = SplitUtil.integers("//_\n1_2_3");
        Integer[] expected = new Integer[]{1, 2, 3};

        assertThat(actual).isEqualTo(expected);
    }

    private static Integer[] expectedResults(String results) {
        return Arrays.stream(results.split(","))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
