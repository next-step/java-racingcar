package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.car.Car;
import racingcar.car.CarName;
import racingcar.engine.FixedGoPowerEngine;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("자동차 위치를 확인하여 true, false로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,true", "1,false"})
    void equalsPosition(int position, boolean expected) {
        //given
        CarName carName = CarName.newInstance("1234");
        Car car = Car.newInstance(carName, new FixedGoPowerEngine());

        //when
        CarStatus carStatus = CarStatus.newInstance(car);
        boolean actual = carStatus.equalsPosition(position);

        //then
        assertEquals(expected, actual);
    }
}
