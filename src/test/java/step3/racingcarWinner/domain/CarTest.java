package step3.racingcarWinner.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi",5);
    }

    @Test
    void move() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(6);
    }

    @Test
    void prizeWinner() {
        car.prizeWinner();
        assertThat(car.isFinalWinner()).isEqualTo(true);
    }

}