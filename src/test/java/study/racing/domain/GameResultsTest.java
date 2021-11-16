package study.racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import study.racing.domain.car.Car;
import study.racing.domain.car.RacingCars;
import study.racing.domain.result.GameResults;
import study.racing.domain.result.Round;
import study.racing.domain.rule.Rule;

class GameResultsTest {

    @DisplayName("gameResults와 마지막 round가 주어졌을 때, winner가 같은지를 검증")
    @ParameterizedTest
    @MethodSource("gameResults")
    void roundTest(GameResults gameResults, Round round) {
        assertThat(gameResults.winners()).isEqualTo(round.winners());
    }

    private static Stream<Arguments> gameResults() {
        Rule trueRule = () -> true;

        Car firstMovedCar = new Car(new Name("test1"));
        Car secondMovedCar = new Car(new Name("test2"));
        Car stoppedCar = new Car(new Name("test3"));

        firstMovedCar.moveOrStop(trueRule);
        secondMovedCar.moveOrStop(trueRule);

        List<Car> carsWithOnlyWinner = Arrays.asList(firstMovedCar, stoppedCar);
        List<Car> carsWithNultiWinner = Arrays.asList(firstMovedCar, secondMovedCar);

        Round roundWithOnlyWinner = new Round(new RacingCars(carsWithOnlyWinner));
        Round roundWithMultiWinner = new Round(new RacingCars(carsWithNultiWinner));

        return Stream.of(Arguments.of(new GameResults(Arrays.asList(roundWithOnlyWinner)), roundWithOnlyWinner),
                         Arguments.of(new GameResults(Arrays.asList(roundWithMultiWinner)), roundWithMultiWinner));
    }
}
