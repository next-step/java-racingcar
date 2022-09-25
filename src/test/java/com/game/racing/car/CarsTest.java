package com.game.racing.car;

import com.game.racing.generator.MovableIntegerGenerator;
import com.game.racing.generator.NotMovableIntegerGenerator;
import com.game.racing.generator.RandomIntegerGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars cars;

    /**
     * 전체 자동차가 RandomIntegerGenerator 를 사용하여 움직이는 경우
     * 움직인 자동차 수가 전체 자동차 수 이하임을 확인한다.
     */
    @Test
    public void cars_moveCars_byRandomIntegerGenerator() {
        Integer carCount = 3;
        cars = new Cars(carCount, new RandomIntegerGenerator());
        Assertions.assertThat(cars.moveCars()).isLessThanOrEqualTo(carCount);
    }

    /**
     * 전체 자동차가 MovableIntegerGenerator 를 사용하여 움직이는 경우
     * 움직인 자동차 수가 전체 자동차 수와 동일한지 확인한다.
     */
    @Test
    public void cars_moveCars_byMovableIntegerGenerator() {
        Integer carCount = 3;
        cars = new Cars(carCount, new MovableIntegerGenerator());
        Assertions.assertThat(cars.moveCars()).isEqualTo(carCount);
    }

    /**
     * 전체 자동차가 NotMovableIntegerGenerator 를 사용하여 움직이는 경우
     * 움직인 자동차 수가 없는지 확인한다.
     */
    @Test
    public void cars_moveCars_byNotMovableIntegerGenerator() {
        Integer carCount = 3;
        cars = new Cars(carCount, new NotMovableIntegerGenerator());
        Assertions.assertThat(cars.moveCars()).isEqualTo(0);
    }

    /**
     * 개별 자동차가 RandomIntegerGenerator 를 사용하여 움직이는 경우
     * 자동차의 움직임이 1 이하임을 확인한다. (1=움직임. 0=안움직임)
     */
    @Test
    public void cars_moveCarByGeneratedValue_byRandomIntegerGenerator() {
        cars = new Cars(1, new RandomIntegerGenerator());
        Car car = new Car();
        Assertions.assertThat(cars.moveCarByGeneratedValue(car)).isLessThanOrEqualTo(1);
    }

    /**
     * 개별 자동차가 MovableIntegerGenerator 를 사용하여 움직이는 경우
     * 자동차의 움직임이 1 임을 확인한다. (1=움직임. 0=안움직임)
     */
    @Test
    public void cars_moveCarByGeneratedValue_byMovableIntegerGenerator() {
        cars = new Cars(1, new MovableIntegerGenerator());
        Car car = new Car();
        Assertions.assertThat(cars.moveCarByGeneratedValue(car)).isEqualTo(1);
    }

    /**
     * 개별 자동차가 NotMovableIntegerGenerator 를 사용하여 움직이는 경우
     * 자동차의 움직임이 0 임을 확인한다. (1=움직임. 0=안움직임)
     */
    @Test
    public void cars_moveCarsByNotMovableIntegerGenerator() {
        cars = new Cars(1, new NotMovableIntegerGenerator());
        Car car = new Car();
        Assertions.assertThat(cars.moveCarByGeneratedValue(car)).isEqualTo(0);
    }

}