package com.game.racing.domain.car;

import com.game.racing.domain.generator.MovableNumberGenerator;
import com.game.racing.domain.generator.NotMovableNumberGenerator;
import com.game.racing.domain.generator.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;
    private final String[] carNames = new String[]{"pobi", "crong", "honux"};

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
        cars = new Cars(carNames, new RandomNumberGenerator());
        cars.moveCars();
        Winner winner = new Winner(cars);
        assertThat(winner.printWinnersAndGetWinnersSize()).isLessThanOrEqualTo(cars.getTotalCarSize());
    }

    /**
     * 전체 자동차가 MovableNumberGenerator 를 사용하여 움직이는 경우
     * 우승 자동차 수가 전체 자동차 수와 동일한지 확인한다.
     */
    @Test
    public void cars_move_all_by_movable_number() {
        cars = new Cars(carNames, new MovableNumberGenerator());
        cars.moveCars();
        Winner winner = new Winner(cars);
        assertThat(winner.printWinnersAndGetWinnersSize()).isEqualTo(cars.getTotalCarSize());
    }

    /**
     * 전체 자동차가 NotMovableNumberGenerator 를 사용하여 움직이는 경우
     * 우승 자동차 수가 전체 자동차 수와 동일한지 확인한다.
     */
    @Test
    void cars_move_all_by_not_movable_number() {
        cars = new Cars(carNames, new NotMovableNumberGenerator());
        cars.moveCars();
        Winner winner = new Winner(cars);
        assertThat(winner.printWinnersAndGetWinnersSize()).isEqualTo(cars.getTotalCarSize());
    }
}