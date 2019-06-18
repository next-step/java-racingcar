package racing.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @ParameterizedTest(name = "split [string={0},delimiter={1},expected={2}]")
    @MethodSource
    void split(String string, String delimiter, List<String> expected) {

        List<String> result = StringUtil.split(string, delimiter);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> split() {
        return Stream.of(
                Arguments.of("test", "", Arrays.asList("t","e","s","t")),
                Arguments.of("t,e,,t", ",", Arrays.asList("t","e","t")),
                Arguments.of("", ",", Collections.emptyList()),
                Arguments.of("", "", Collections.emptyList())
        );
    }
}