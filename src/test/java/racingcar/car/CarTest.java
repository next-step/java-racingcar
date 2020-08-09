package racingcar.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 자동차_생성_성공() {
        Car car = new Car();
        assertThat(car.getStatus()).isEqualTo(1);
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차_임의상태값_성공() {
        Car car = new Car(3);
        assertThat(car.getStatus()).isEqualTo(3);
    }



}