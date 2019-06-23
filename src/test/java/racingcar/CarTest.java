package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    @BeforeEach
    void setUp() {
        car = new Car("alice", 0);
    }

    @Test
    void testCarMove() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);

        car.move();
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);


    }
}
