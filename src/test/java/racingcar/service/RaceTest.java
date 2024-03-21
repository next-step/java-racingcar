package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.TestRacingCarConfig;
import racingcar.domain.Rounds;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.domain.movement.MovementStrategy;
import racingcar.vo.GameResult;

class RaceTest {

    private static MovementStrategy basicStopStrategy;

    @BeforeAll
    static void setUp() {
        basicStopStrategy = TestRacingCarConfig.basicStopStrategy();
    }

    @Test
    @DisplayName("우승자가 한 명인 자동차 경주 결과를 반환한다.")
    void progress_SingleWinner_GameResult() {
        final Cars cars = new Cars(
                new Car("kyle", 2),
                new Car("alex", 1),
                new Car("haley", 0)
        );

        final Rounds rounds = Rounds.from(1);
        final GameResult result = new Race().progress(cars, rounds, basicStopStrategy);

        assertThat(result.winnerNames())
                .hasSize(1)
                .containsOnly("kyle");
    }

    @Test
    @DisplayName("우승자가 여러 명인 자동차 경주 결과를 반환한다.")
    void progress_MultipleWinners_GameResult() {
        final Cars cars = new Cars(
                new Car("kyle", 2),
                new Car("alex", 2),
                new Car("haley", 0)
        );

        final Rounds rounds = Rounds.from(1);
        final GameResult result = new Race().progress(cars, rounds, basicStopStrategy);

        assertThat(result.winnerNames())
                .hasSize(2)
                .containsOnly("kyle", "alex");
    }
}
