package com.game.racing.car;

import com.game.racing.generator.MovableNumberGenerator;
import com.game.racing.generator.NotMovableNumberGenerator;
import com.game.racing.generator.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.*;

import com.game.racing.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars cars;
    private final String carNames = "pobi,crong,honux";
    private final String carName = "honux";

    @BeforeEach
    void set_up() {
        Position.resetMaxValue();
    }

    @Test
    void cars_naming_error() {
        String notAcceptableCarNames = "pobi,crong,honux123";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            cars = new Cars(notAcceptableCarNames, new RandomNumberGenerator());
        });
    }

    /**
     * 전체 자동차가 RandomIntegerGenerator 를 사용하여 움직이는 경우
     * 우승 자동차 수가 전체 자동차 수 이하임을 확인한다.
     */
    @Test
    void cars_move_all_by_random_number() {
        cars = new Cars(carNames, new RandomNumberGenerator());
        cars.moveCars();
        assertThat(cars.getRacingWinners().size()).isLessThanOrEqualTo(cars.getTotalCarSize());
    }

    /**
     * 전체 자동차가 MovableIntegerGenerator 를 사용하여 움직이는 경우
     * 위치가 1이고, 우승 자동차 수가 전체 자동차 수와 동일한지 확인한다.
     */
    @Test
    public void cars_move_all_by_movable_number() {
        cars = new Cars(carNames, new MovableNumberGenerator());
        cars.moveCars();
        assertThat(cars.getCarByName(carName).getPosition().get()).isEqualTo(1);
        assertThat(cars.getRacingWinners().size()).isEqualTo(cars.getTotalCarSize());
    }

    /**
     * 전체 자동차가 NotMovableIntegerGenerator 를 사용하여 움직이는 경우
     * 위치가 0이고, 우승 자동차 수가 전체 자동차 수와 동일한지 확인한다.
     */
    @Test
    void cars_move_all_by_not_movable_number() {
        cars = new Cars(carNames, new NotMovableNumberGenerator());
        cars.moveCars();
        assertThat(cars.getCarByName(carName).getPosition().get()).isZero();
        assertThat(cars.getRacingWinners().size()).isEqualTo(cars.getTotalCarSize());
    }

    /**
     * 개별 자동차가 RandomIntegerGenerator 를 사용하여 움직이는 경우
     * 우승 자동차 수가 1 혹은 3 임을 확인한다. (1=한대 움직임. 3=모두 안움직임)
     */
    @Test
    void cars_move_each_car_by_random_number() {
        cars = new Cars(carNames, new RandomNumberGenerator());
        Car car = cars.getCarByName(carName);
        cars.moveCarByGeneratedValue(car);
        assertThat(cars.getRacingWinners().size()).isIn(1, cars.getTotalCarSize());
    }

    /**
     * 개별 자동차가 MovableIntegerGenerator 를 사용하여 움직이는 경우
     * 우승 자동차 수가 1 임을 확인한다.
     */
    @Test
    void cars_move_each_car_by_movable_number() {
        cars = new Cars(carNames, new MovableNumberGenerator());
        Car car = cars.getCarByName(carName);
        cars.moveCarByGeneratedValue(car);
        assertThat(cars.getRacingWinners().size()).isEqualTo(1);
    }

    /**
     * 개별 자동차가 NotMovableIntegerGenerator 를 사용하여 움직이는 경우
     * 우승 자동차 수가 3 임을 확인한다. (1=한대 움직임. 3=모두 안움직임)
     */
    @Test
    void cars_move_each_car_by_not_movable_number() {
        cars = new Cars(carNames, new NotMovableNumberGenerator());
        Car car = cars.getCarByName(carName);
        cars.moveCarByGeneratedValue(car);
        assertThat(cars.getRacingWinners().size()).isEqualTo(cars.getTotalCarSize());
    }

}