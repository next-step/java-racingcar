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
    @MethodSource("gameResultsAndLastRound")
    void roundTest(GameResults gameResults, Round round) {
        assertThat(gameResults.winners()).isEqualTo(round.winners());
    }

    private static Stream<Arguments> gameResultsAndLastRound() {
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

    @DisplayName("Round list를 통해 생성된 gameResults가 unmodifiableList로 모든 round를 반환하는지 검증")
    @ParameterizedTest
    @MethodSource("gameResultsAndRoundCount")
    void allRoundResultsTest(GameResults gameResults, List<Round> rounds) {
        List<Round> allRoundResults = gameResults.allRoundResults();
        assertThat(gameResults.allRoundResults().size()).isEqualTo(rounds.size());
        assertThatThrownBy(() -> allRoundResults.add(rounds.get(0))).isInstanceOf(UnsupportedOperationException.class);
    }

    private static Stream<Arguments> gameResultsAndRoundCount() {
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

        return Stream.of(Arguments.of(new GameResults(Arrays.asList(roundWithOnlyWinner)), Arrays.asList(roundWithOnlyWinner)),
                         Arguments.of(new GameResults(Arrays.asList(roundWithMultiWinner)), Arrays.asList(roundWithMultiWinner)));
    }
}
