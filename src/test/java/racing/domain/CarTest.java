package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void GO_출력() {
        Car car = new Car();
        car.move(1);
        assertThat(car.positionStatus()).isEqualTo("-");
    }

    @Test
    void STOP_출력() {
        Car car = new Car();
        car.move(0);
        assertThat(car.positionStatus()).isEqualTo("");
    }

    @Test
    void 여러번_이동_출력() {
        Car car = new Car();
        car.move(0);
        car.move(1);
        car.move(1);
        assertThat(car.positionStatus()).isEqualTo("--");
    }
}
