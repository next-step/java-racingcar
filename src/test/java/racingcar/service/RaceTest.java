package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.RacingCarException.PLAYING_COUNT_OUT_OF_RANGE;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.TestRacingCarConfig;
import racingcar.domain.cars.CarNames;
import racingcar.domain.cars.Cars;
import racingcar.domain.movement.MovementStrategy;
import racingcar.vo.GameResult;

class RaceTest {

    private static String[] names;
    private static CarNames carNames;
    private static MovementStrategy basicMoveForwardStrategy;
    private Cars cars;

    @BeforeAll
    static void setUp() {
        names = new String[] {"kyle", "alex", "haley"};
        carNames = CarNames.from(names);
        basicMoveForwardStrategy = TestRacingCarConfig.basicMoveForwardStrategy();
    }

    @BeforeEach
    void init() {
        cars = Cars.from(carNames);
    }

    @Test
    @DisplayName("자동차 경주를 진행하면 그에 따른 경주 결과를 반환한다.")
    void progress_GameResult_WinnerNames() {
        final int playingCount = 1;
        final GameResult result = new Race().progress(cars, playingCount, basicMoveForwardStrategy);

        assertThat(result.winnerNames())
                .containsOnly(names);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("0 이하의 레이싱 시도 횟수만큼 경주를 하려는 경우 예외를 던진다.")
    void progress_NegativeOrZeroPlayingCount_Exception(final int negativeOrZeroPlayingCount) {
        assertThatThrownBy(() -> new Race().progress(cars, negativeOrZeroPlayingCount, basicMoveForwardStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYING_COUNT_OUT_OF_RANGE.message(negativeOrZeroPlayingCount));
    }
}
