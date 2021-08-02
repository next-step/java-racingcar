package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRacerTest {
    @Test
    void 자동차_앞으로_1칸_전진() {
        Car car = new Car(1);
        car.moveForward();
        Assertions.assertThat(car.getCurrentPosition()).isEqualTo(2);
    }
}