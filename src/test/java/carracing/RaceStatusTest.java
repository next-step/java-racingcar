package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RaceStatusTest {
    @ParameterizedTest
    @MethodSource("hyphenExpressionParameter")
    @DisplayName("전달된 position 값들을을 \"-\"으로 표현한다.")
    void testHyphenExpression(List<Integer> positionOfCarList, String expectedHyphenExpression) {
        RaceStatus raceStatus = new RaceStatus(positionOfCarList);
        assertThat(raceStatus.hyphenExpression()).isEqualTo(expectedHyphenExpression);
    }

    static Stream<Arguments> hyphenExpressionParameter() {
        return Stream.of(
                Arguments.arguments(givenPositions(1, 1, 1), "-\n-\n-\n"),
                Arguments.arguments(givenPositions(2, 1, 2), "--\n-\n--\n"),
                Arguments.arguments(givenPositions(3, 2, 3), "---\n--\n---\n"),
                Arguments.arguments(givenPositions(4, 3, 4), "----\n---\n----\n"),
                Arguments.arguments(givenPositions(4, 4, 5), "----\n----\n-----\n")
        );
    }

    private static List<Integer> givenPositions(int... positions) {
        return Arrays.stream(positions)
                .boxed()
                .collect(Collectors.toList());
    }
}