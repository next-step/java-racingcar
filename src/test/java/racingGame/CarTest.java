package racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void move() {
        car.move();
        car.move();
        car.move();

        assertThat(car.getPosition()).isEqualTo(3);

        car.move();
        car.move();

        assertThat(car.getPosition()).isEqualTo(5);
    }

}