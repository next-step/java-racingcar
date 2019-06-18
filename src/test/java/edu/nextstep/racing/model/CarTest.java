package edu.nextstep.racing.model;

import org.junit.jupiter.api.BeforeEach;
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

    private Car car;

    @BeforeEach
    void 사전설정() {
        car = new Car("TEST");
    }

    @Test
    void 자동차_이름_가져오기() {
        assertThat(car.getCarNumber()).isEqualTo("test");
    }

    @Test
    void 자동차_생성번호_가져오기() {
        assertThat(car.getCarNumber()).isEqualTo(0);
    }
}