package edu.nextstep.racingcar.step4.domain;

import edu.nextstep.racingcar.common.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("자동차 이름 5글자 초과 테스트")
    @Test
    void too_long_car_name() {
        assertThatThrownBy(() -> new Car(new CarName("test12345"))).isInstanceOf(BusinessException.class);
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void move() {
        Car car = new Car(new CarName("test"));

        do {
            car.move(new DefaultMoveStrategy());
        } while (car.getDistance() < 10);

        assertThat(car.getDistance()).isNotEqualTo(1);
    }
}
