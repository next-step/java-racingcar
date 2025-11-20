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

    @Test
    void isMaxPosition() {
        Car car = new Car("pobi", 3);
        assertThat(car.isMaxPosition(3)).isTrue();
        assertThat(car.isMaxPosition(2)).isFalse();
    }

    @Test
    void max() {
        Car car = new Car("pobi", 3);
        assertThat(car.max(2)).isEqualTo(3);
        assertThat(car.max(4)).isEqualTo(4);
    }
}
