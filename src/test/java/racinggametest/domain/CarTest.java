package racinggametest.domain;

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
    void isWinnerTest() {
        assertThat(testCar.isWinner(6)).isFalse();
        assertThat(testCar.isWinner(5)).isTrue();
    }
}
