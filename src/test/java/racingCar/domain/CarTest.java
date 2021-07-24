package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 전진, 정지 후 거리 확인")
    @Test
    void createCarTest(){
        Car car = new Car();
        assertThat(car.getCarDistance()).isEqualTo(0);
        car = car.move(true);
        assertThat(car.getCarDistance()).isEqualTo(1);
        car = car.move(false);
        assertThat(car.getCarDistance()).isEqualTo(1);
    }

}