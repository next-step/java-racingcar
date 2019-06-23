package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.NumGenerator;

import static org.assertj.core.api.Assertions.assertThat;



public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        NumGenerator goingNum = new FixedNumGenerator(5);
        car = new Car("alice", 0, goingNum);
    }

    @Test
    void testGoAndStopCar() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);

        car.setNumGenerator(new FixedNumGenerator(3));
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);

    }
}
