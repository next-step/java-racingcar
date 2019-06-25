package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        this.car = Car.of(new CarName("hennry"), new Position());
    }

    @Test
    void move() {
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void ifCarNameNullThrowIllegalException() {
        assertThatThrownBy(() -> Car.of(new CarName(null), new Position())).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Car.of(new CarName(""), new Position())).isInstanceOf(IllegalArgumentException.class);
    }
}
