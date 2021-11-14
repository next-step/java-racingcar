package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.StringUtils.split;

class StringUtilsTest {

    @ParameterizedTest
    @DisplayName("문자열 split 테스트")
    @MethodSource
    void splitTest(String str, String[] expected) {
        String[] split = split(str);

        assertThat(split).isEqualTo(expected);
    }

    static Stream<Arguments> splitTest() {
        return Stream.of(
                Arguments.of(
                        "a,b,c",
                        new String[] {"a", "b", "c"}
                )
        );
    }
}