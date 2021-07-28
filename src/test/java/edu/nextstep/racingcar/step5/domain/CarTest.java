package edu.nextstep.racingcar.step5.domain;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step4.domain.Car;
import edu.nextstep.racingcar.step4.domain.CarName;
import edu.nextstep.racingcar.step4.domain.DefaultMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("자동차 이름 5글자 초과 테스트")
    @Test
    void too_long_car_name() {
        assertThatThrownBy(() -> new edu.nextstep.racingcar.step4.domain.Car(new edu.nextstep.racingcar.step4.domain.CarName("test12345"))).isInstanceOf(BusinessException.class);
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void move() {
        edu.nextstep.racingcar.step4.domain.Car car = new Car(new CarName("test"));

        do {
            car.move(new DefaultMoveStrategy());
        } while (car.getDistance() < 10);

        assertThat(car.getDistance()).isNotEqualTo(1);
    }
}
