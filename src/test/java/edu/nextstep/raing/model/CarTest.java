package edu.nextstep.raing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-16 14:40
 */
class CarTest {

    private Car car = new Car();

    @Test
    void 이동() {
        assertThat(car.move()).isEqualTo(1);
        assertThat(car.move()).isEqualTo(2);
        assertThat(car.move()).isEqualTo(3);
    }

    @Test
    void 자동차_현재위치() {
        car.move();
        assertThat(car.currentPosition()).isEqualTo(1);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(2);
    }
}