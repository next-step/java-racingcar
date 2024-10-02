package racingcar.winner.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void car_이름반환() {
        Car car = new Car("Joon");
        assertThat(car.getName()).isEqualTo("Joon");
    }
}
