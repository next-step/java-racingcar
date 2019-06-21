package edu.nextstep.racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
        assertThat(car.getCarName()).isEqualTo("TESTR");
    }

    @Test
    void 자동차_생성번호_가져오기() {
        assertThat(car.getCarNumber(0)).isTrue();
    }

    @Test
    void 자동차_생성_NULL_예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car exceptionCar = new Car(null);
        });
    }

    @Test
    void 자동차_생성_공백_예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car exceptionCar = new Car("");
        });
    }

    @Test
    @DisplayName("자동차 전진 기능")
    void 전진_현재_위치반환() {
        assertThat(car.move(4)).isEqualTo(1);
    }
}