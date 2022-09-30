package step3.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameResultTest {
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void Given_CarList_When_GetWinnersList_Then_Equals(List<List<Car>> carList, List<String> expectedWinnerList) {
        List<Car> winners = new GameResult(carList).getWinners();

        assertThat(winners.size()).isEqualTo(expectedWinnerList.size());

        IntStream.range(0, winners.size()).boxed()
                .forEach(i -> assertThat(winners.get(i)).isEqualTo(expectedWinnerList.get(i)));
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments(
                        List.of(
                                List.of(new Car("a", 0), new Car("b", 1))
                        ),
                        List.of(new Car("b", 1))
                ),
                arguments(
                        List.of(
                                List.of(new Car("a", 1), new Car("b", 1))
                        ),
                        List.of(new Car("a", 1), new Car("b", 1))
                ),
                arguments(
                        List.of(
                                List.of(new Car("a", 2), new Car("b", 1), new Car("c", 2))
                        ),
                        List.of(new Car("a", 2), new Car("c", 2))
                )
        );
    }
}
