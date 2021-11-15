package study.racing.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import study.racing.model.car.Car;
import study.racing.model.car.RacingCars;
import study.racing.model.result.GameResults;
import study.racing.model.result.RoundResult;
import study.racing.model.rule.Rule;

class GameResultsTest {

    @DisplayName("라운드")
    @ParameterizedTest
    @MethodSource("racingCars")
    void roundTest(GameResults gameResults, List<Car> winners) {
        assertThat(gameResults.winners()).isEqualTo(winners);
    }

    private static Stream<Arguments> racingCars() {
        Rule trueRule = () -> true;

        Car movedCar1 = new Car("test1");
        movedCar1.moveOrStop(trueRule);
        Car stoppedCar = new Car("test2");

        List<Car> carsWithOnlyWinner = Arrays.asList(movedCar1, stoppedCar);

        Car movedCar2 = new Car("test3");
        movedCar2.moveOrStop(trueRule);
        List<Car> carsWithNultiWinner = Arrays.asList(movedCar1, movedCar2);

        RoundResult resultWithOnlyWinner = new RoundResult(new RacingCars(carsWithOnlyWinner));
        RoundResult resultWithMultiWinner = new RoundResult(new RacingCars(carsWithNultiWinner));
        return Stream.of(
                Arguments.of(new GameResults(Arrays.asList(resultWithOnlyWinner)), Arrays.asList(movedCar1)),
                Arguments.of(new GameResults(Arrays.asList(resultWithMultiWinner)), Arrays.asList(movedCar1, movedCar2)));
    }
}
