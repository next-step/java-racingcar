package RacingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void setCar() {
        int position = car.getPosition();
        assertThat(position).isEqualTo(0);
    }

    @Test
    void move() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }
}