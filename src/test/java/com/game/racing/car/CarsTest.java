package com.game.racing.car;

import com.game.racing.generator.MovableNumberGenerator;
import com.game.racing.generator.NotMovableNumberGenerator;
import com.game.racing.generator.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars cars;

    /**
     * 전체 자동차가 RandomIntegerGenerator 를 사용하여 움직이는 경우
     * 움직인 자동차 수가 전체 자동차 수 이하임을 확인한다.
     */
    @Test
    void cars_move_all_by_random_number() {
        Integer carCount = 3;
        cars = new Cars(carCount, new RandomNumberGenerator());
        cars.moveCars();
        Assertions.assertThat(cars.getMovedCarTotalCount()).isLessThanOrEqualTo(carCount);
    }

    /**
     * 전체 자동차가 MovableIntegerGenerator 를 사용하여 움직이는 경우
     * 움직인 자동차 수가 전체 자동차 수와 동일한지 확인한다.
     */
    @Test
    public void cars_move_all_by_movable_number() {
        Integer carCount = 3;
        cars = new Cars(carCount, new MovableNumberGenerator());
        cars.moveCars();
        Assertions.assertThat(cars.getMovedCarTotalCount()).isEqualTo(carCount);
    }

    /**
     * 전체 자동차가 NotMovableIntegerGenerator 를 사용하여 움직이는 경우
     * 움직인 자동차 수가 없는지 확인한다.
     */
    @Test
    void cars_move_all_by_not_movable_number() {
        Integer carCount = 3;
        cars = new Cars(carCount, new NotMovableNumberGenerator());
        cars.moveCars();
        Assertions.assertThat(cars.getMovedCarTotalCount()).isZero();
    }

    /**
     * 개별 자동차가 RandomIntegerGenerator 를 사용하여 움직이는 경우
     * 자동차의 움직임이 1 이하임을 확인한다. (1=움직임. 0=안움직임)
     */
    @Test
    void cars_move_each_car_by_random_number() {
        cars = new Cars(1, new RandomNumberGenerator());
        Car car = new Car();
        cars.moveCarByGeneratedValue(car);
        Assertions.assertThat(cars.getMovedCarTotalCount()).isLessThanOrEqualTo(1);
    }

    /**
     * 개별 자동차가 MovableIntegerGenerator 를 사용하여 움직이는 경우
     * 자동차의 움직임이 1 임을 확인한다. (1=움직임. 0=안움직임)
     */
    @Test
    void cars_move_each_car_by_movable_number() {
        cars = new Cars(1, new MovableNumberGenerator());
        Car car = new Car();
        cars.moveCarByGeneratedValue(car);
        Assertions.assertThat(cars.getMovedCarTotalCount()).isEqualTo(1);
    }

    /**
     * 개별 자동차가 NotMovableIntegerGenerator 를 사용하여 움직이는 경우
     * 자동차의 움직임이 0 임을 확인한다. (1=움직임. 0=안움직임)
     */
    @Test
    void cars_move_each_car_by_not_movable_number() {
        cars = new Cars(1, new NotMovableNumberGenerator());
        Car car = new Car();
        cars.moveCarByGeneratedValue(car);
        Assertions.assertThat(cars.getMovedCarTotalCount()).isZero();
    }

}