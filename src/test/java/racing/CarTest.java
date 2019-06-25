package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car(new CarName("hennry"), new Position());
    }

    @Test
    void move() {
        car.move(5L);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        car.move(3L);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void ifCarNameNullThrowIllegalException() {
        assertThatThrownBy(() -> new Car(new CarName(null), new Position())).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(new CarName(""), new Position())).isInstanceOf(IllegalArgumentException.class);
    }
}
