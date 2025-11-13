package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void 이름_invalid() {
        assertThatThrownBy(() -> {
            new Car("pobi12");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이동() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
