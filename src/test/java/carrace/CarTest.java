package carrace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차는 이동할 수 있고, 이동시 position 이 1 증가한다.")
    void move() {
        final Car car = new Car();
        car.move();
        final int position = car.getPosition();

        assertThat(position).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 이동할 수 있고, 이동시 position 이 1 증가한다.")
    void moveNotZero() {
        final Car car = new Car(2);
        car.move();
        final int position = car.getPosition();

        assertThat(position).isEqualTo(3);
    }
}
