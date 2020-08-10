package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarName;
import racingcar.engine.FixedGoPowerEngine;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarStatusTest {
    @DisplayName("자동차 상태 저장 객체 생성")
    @Test
    void newInstance() {
        //given
        CarName carName = CarName.newInstance("1234");
        Car car = Car.newInstance(carName, new FixedGoPowerEngine());

        //when
        CarStatus carStatus = CarStatus.newInstance(car);

        //then
        assertSoftly(soft -> {
            soft.assertThat(carStatus.getCarName()).isEqualTo(carName.getName());
            soft.assertThat(carStatus.getPosition()).isEqualTo(0);
        });
    }
}
