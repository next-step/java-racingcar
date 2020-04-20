package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car testCar;

    @BeforeEach
    void setUp() {
        testCar = new Car("testCar", 5);
    }

    @Test
    void moveCarTest() {
        testCar.moveCar(() -> true);
        assertThat(testCar.getPosition()).isEqualTo(6);
    }

    @Test
    void doNotMoveCarTest() {
        testCar.moveCar(() -> false);
        assertThat(testCar.getPosition()).isEqualTo(5);
    }

    @Test
    void isInPositionTest() {
        assertThat(testCar.isInPosition(6)).isFalse();
        assertThat(testCar.isInPosition(5)).isTrue();
    }
}
