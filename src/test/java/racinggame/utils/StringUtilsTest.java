package racinggame.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.RacingGame.CAR_NAME_DELIMITER;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringUtilsTest {

    @ParameterizedTest
    @MethodSource("generatedCarFixture")
    void 경주에_참가할_자동차_이름들을_리스트로_분리할_수_있다(String input, String[] expectedResult, int expectedSize) {
        List<String> result = StringUtils.splitToList(input, CAR_NAME_DELIMITER);

        assertThat(result).containsExactly(expectedResult);
        assertThat(result).size().isEqualTo(expectedSize);
    }

    static Stream<Arguments> generatedCarFixture() {
        return Stream.of(
                Arguments.of("first,second,third,force", new String[]{"first", "second", "third", "force"}, 4),
                Arguments.of("first,second,third", new String[]{"first", "second", "third"}, 3),
                Arguments.of("first,second", new String[]{"first", "second"}, 2),
                Arguments.of("first", new String[]{"first"}, 1),
                Arguments.of("", new String[]{}, 0),
                Arguments.of(null, new String[]{}, 0)
        );
    }

}