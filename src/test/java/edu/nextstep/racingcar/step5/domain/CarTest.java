package edu.nextstep.racingcar.step5.domain;

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

    @DisplayName("자동차 이동 테스트 (이동 정책: true)")
    @Test
    void move_when_strategy_is_true() {
        Car car = new Car(new CarName("test"));

        car.move(() -> true);

        assertThat(car.getDistance()).isGreaterThan(1);
    }

    @DisplayName("자동차 이동 테스트 (이동 정책: false)")
    @Test
    void move_when_strategy_is_false() {
        Car car = new Car(new CarName("test"));

        car.move(() -> false);

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
