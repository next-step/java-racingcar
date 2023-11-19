package calculator.separator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CustomSeparatorTest {

    private Separator separator;

    @BeforeEach
    void setUp() {
        separator = new CustomSeparator();
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자를 사용했는지 확인한다.")
    @MethodSource("matchableMethodParametersProvider")
    void matchable(String given, boolean expected) {
        // when
        boolean result = separator.matchable(given);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> matchableMethodParametersProvider() {
        return Stream.of(
                arguments("//&\n1&3", true),
                arguments("/&\n1&3", false),
                arguments("\n&//3&4", false)
        );
    }

    @ParameterizedTest
    @DisplayName("문자열 앞부분에 // 와 \n 사이의 문자를 커스텀 구분자로 사용해 문자열을 분리한다.")
    @MethodSource(value = "separateMethodParametersProvider")
    void separate(String given, List<String> expected) {
        // when
        List<String> result = separator.separate(given);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> separateMethodParametersProvider() {
        return Stream.of(
                arguments("//&\n1&3", Arrays.asList("1", "3")),
                arguments("//$\n1$3", Arrays.asList("1", "3")),
                arguments("//@$\n1@$3", Arrays.asList("1", "3"))
        );
    }
}