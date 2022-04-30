package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    final int GO = 1;
    final int STOP = 0;

    @Test
    @DisplayName("전진 시 결과값 확인")
    void move() {
        Car car = new Car("jess");

        car.move(() -> GO);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("움직이지 않았을 때 결과값 확인")
    void stop() {
        Car car = new Car("jess");

        car.move(() -> STOP);
        assertThat(car.getPosition()).isEqualTo(0);
    }


}