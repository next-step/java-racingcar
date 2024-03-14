package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
