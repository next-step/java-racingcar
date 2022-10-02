package com.game.racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import com.game.racing.domain.generator.MovableNumberGenerator;
import com.game.racing.domain.generator.NotMovableNumberGenerator;
import com.game.racing.domain.generator.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

public class CarTest {

    private final String carName = "honux";

    /**
     * 자동차가 RandomNumberGenerator 를 사용하여 움직이는 경우
     * 움직인 거리가 1 이하임을 확인한다
     */
    @Test
    void cars_move_by_random_number() {
        Car car = new Car(carName, new RandomNumberGenerator());
        car.move();
        assertThat(car.getPosition().get()).isLessThanOrEqualTo(1);
    }

    /**
     * 자동차가 MovableNumberGenerator 를 사용하여 움직이는 경우
     * 움직인 거리가 1 임을 확인한다
     */
    @Test
    void cars_move_by_movable_number() {
        Car car = new Car(carName, new MovableNumberGenerator());
        car.move();
        assertThat(car.getPosition().get()).isEqualTo(1);
    }

    /**
     * 자동차가 NotMovableNumberGenerator 를 사용하여 움직이는 경우
     * 움직인 거리가 0 임을 확인한다
     */
    @Test
    void cars_move_by_not_movable_number() {
        Car car = new Car(carName, new NotMovableNumberGenerator());
        car.move();
        assertThat(car.getPosition().get()).isZero();
    }

}