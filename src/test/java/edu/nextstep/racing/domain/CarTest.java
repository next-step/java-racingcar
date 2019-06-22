package edu.nextstep.racing.domain;

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
 * create date  : 2019-06-22 14:08
 */
public class CarTest {

    private Car car;

    @BeforeEach
    void 설정() {
        car = new Car("TEST");
    }

    @Test
    void 자동차_전진() {
        car.carMove(4);
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_이름가져오기() {
        assertThat(car.getCarName()).isEqualTo("TEST");
    }

    @Test
    void 자동차_현재위치가져오기() {
        assertThat(car.getCarPosition()).isEqualTo(0);
    }
}
