package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("3 이하면 이동하지 않는다.")
    @Test
    void move_1() {
        Car car = new Car(new CarName("east"));
        car.move(3);
        Assertions.assertThat(car.position()).isEqualTo(0);
    }

    @DisplayName("4 이상히면 이동한다.")
    @Test
    void move_2() {
        Car car = new Car(new CarName("east"));
        car.move(4);
        Assertions.assertThat(car.position()).isEqualTo(1);
    }

}
