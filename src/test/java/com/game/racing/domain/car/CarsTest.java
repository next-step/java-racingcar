package com.game.racing.domain.car;

import com.game.racing.domain.generator.MovableNumberGenerator;
import com.game.racing.domain.generator.NotMovableNumberGenerator;
import com.game.racing.service.RacingGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private RacingGameService racingGameService;
    private Cars cars;
    private final String[] carNames = new String[]{"pobi", "crong", "honux"};
    private final Integer tryCount = 5;

    @BeforeEach
    void set_up() {
        Winner.resetWinnerPositionValue();
    }

    /**
     * 전체 자동차가 RandomNumberGenerator 를 사용하여 움직이는 경우
     * 우승 자동차 수가 전체 자동차 수 이하임을 확인한다.
     */
    @Test
    void cars_move_all_by_random_number() {
        racingGameService = new RacingGameService(carNames, tryCount);
        cars = racingGameService.moveCarsByTryCountAndGetCars();
        assertThat(cars.getRacingWinners().size()).isLessThanOrEqualTo(cars.getTotalCarSize());
    }

    /**
     * 전체 자동차가 MovableNumberGenerator 를 사용하여 움직이는 경우
     * 우승 자동차 수가 전체 자동차 수와 동일한지 확인한다.
     */
    @Test
    public void cars_move_all_by_movable_number() {
        racingGameService = new RacingGameService(carNames, tryCount, new MovableNumberGenerator());
        cars = racingGameService.moveCarsByTryCountAndGetCars();
        assertThat(cars.getRacingWinners().size()).isEqualTo(cars.getTotalCarSize());
    }

    /**
     * 전체 자동차가 NotMovableNumberGenerator 를 사용하여 움직이는 경우
     * 우승 자동차 수가 전체 자동차 수와 동일한지 확인한다.
     */
    @Test
    void cars_move_all_by_not_movable_number() {
        racingGameService = new RacingGameService(carNames, tryCount, new NotMovableNumberGenerator());
        cars = racingGameService.moveCarsByTryCountAndGetCars();
        assertThat(cars.getRacingWinners().size()).isEqualTo(cars.getTotalCarSize());
    }
}