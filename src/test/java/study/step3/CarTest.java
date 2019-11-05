package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Movable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private static final String NAME = "test";
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(NAME);
    }

    @Test
    void nameTest() {
        assertThat(car.getName()).contains("test");
    }

    @Test
    void currentPositionTest() {
        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @Test
    void moveTest() {
        assertThat(car.move(() -> false)).isEqualTo(0);
        assertThat(car.move(() -> true)).isEqualTo(1);
    }

    @Test
    void checkPositionsBoundException() {
        assertThatThrownBy(() -> {
            car.isPositionValue(1);
        }).hasSameClassAs(IndexOutOfBoundsException.class);
    }
}
