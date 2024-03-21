package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.RacingCarException.PLAYING_COUNT_OUT_OF_RANGE;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.TestRacingCarConfig;
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
    void progress_GameResult_WinnerNames() {
        final Cars cars = new Cars(
                new Car("kyle", 2),
                new Car("alex", 1),
                new Car("haley", 0)
        );

        final int playingCount = 1;
        final GameResult result = new Race().progress(cars, playingCount, basicStopStrategy);

        assertThat(result.winnerNames())
                .hasSize(1)
                .containsOnly("kyle");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("0 이하의 레이싱 시도 횟수만큼 경주를 하려는 경우 예외를 던진다.")
    void progress_NegativeOrZeroPlayingCount_Exception(final int negativeOrZeroPlayingCount) {
        final Cars cars = new Cars(
                new Car("kyle", 0),
                new Car("alex", 0)
        );

        assertThatThrownBy(() -> new Race().progress(cars, negativeOrZeroPlayingCount, basicStopStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYING_COUNT_OUT_OF_RANGE.message(negativeOrZeroPlayingCount));
    }
}
