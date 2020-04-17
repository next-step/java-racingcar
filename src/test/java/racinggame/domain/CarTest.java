package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car testCar;

    @BeforeEach
    void setUp() {
        testCar = new Car("testCar", 5);
    }

    @Test
    void moveCarTest() {
        testCar.moveCar();
        assertThat(testCar.getPosition()).isEqualTo(6);
    }

    @Test
    void isInPositionTest() {
        assertThat(testCar.isInPsition(6)).isFalse();
        assertThat(testCar.isInPsition(5)).isTrue();
    }
}
