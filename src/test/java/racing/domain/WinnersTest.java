package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnersTest {

    @ParameterizedTest
    @DisplayName("레이싱의 결과와 우승자가 일치하는 지 테스트")
    @MethodSource("provideStringsForWinnerTest")
    void isWinnersEqualWithRacingResult(List<Car> input, List<String> expected) {
        List<String> winners = Winners.getWinners(input);

        assertThat(winners).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringsForWinnerTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(new Car("hello", 5), new Car("world", 6))
                        , Arrays.asList("world")),
                Arguments.of(
                        Arrays.asList(new Car("hello", 6), new Car("world", 6))
                        , Arrays.asList("hello","world"))
        );
    }
}
