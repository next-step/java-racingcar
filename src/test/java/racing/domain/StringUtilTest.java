package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.util.StringUtil;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class StringUtilTest {

    @ParameterizedTest
    @MethodSource("provideStringsForSplit")
    void splitStringToList(String str, String delimiter, List<String> names) {
        assertThat(StringUtil.splitStringToList(str, delimiter)).containsExactlyElementsOf(names);
    }

    private static Stream<Arguments> provideStringsForSplit() {
        return Stream.of(
                Arguments.of("nimoh", ",", List.of("nimoh")),
                Arguments.of("nimoh: pobi", ":", List.of("nimoh","pobi")),
                Arguments.of("nimoh   ;   pobi;   speed", ";", List.of("nimoh", "pobi", "speed"))
        );
    }
}