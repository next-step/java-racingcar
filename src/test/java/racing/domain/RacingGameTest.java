package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.car.Car;
import racing.domain.car.Cars;

class RacingGameTest {

    private static Stream<Arguments> 레이싱_진행() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(
                    new Car("a", 2),
                    new Car("b", 4),
                    new Car("C", 1)
                )
            )
        );
    }

    private static Stream<Arguments> 우승자_결졍() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(
                    new Car("a", 2),
                    new Car("b", 4),
                    new Car("cd", 4)
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource
    void 레이싱_진행(List<Car> cars) {
        RacingGame racingGame = new RacingGame(new Cars(cars));
        racingGame.race(new TryNumber(1));
        assertThat(racingGame.raceResult().stream().count()).isEqualTo(1);
        assertThat(racingGame.raceResult().get(0).getCars().stream().count()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource
    void 우승자_결졍(List<Car> cars) {
        RacingGame racingGame = new RacingGame(new Cars(cars));
        assertThat(racingGame.decideWinners()).isEqualTo("b, cd");
    }
}