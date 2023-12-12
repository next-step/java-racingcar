package race.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("정지")
    void stop() {
        Car car = new Car("test");
        car.move(() -> false);
        int position = car.position();

        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("이동")
    void move() {
        Car car = new Car("test");
        car.move(() -> true);
        int position = car.position();

        assertThat(position).isEqualTo(1);
    }



}