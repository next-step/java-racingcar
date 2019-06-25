package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.NumGenerator;

import static org.assertj.core.api.Assertions.assertThat;



public class CarTest {
    private Car goingCar;
    private Car stopCar;


    @BeforeEach
    void setUp() {
        NumGenerator goingNum = new FixedNumGenerator(5);
        NumGenerator stopNum = new FixedNumGenerator(3);
        goingCar = new Car("alice", 0, goingNum);
        stopCar = new Car("alice", 0, stopNum);

    }

    @Test
    void testGoAndStopCar() {
        goingCar.move();
        assertThat(goingCar.getPosition()).isEqualTo(1);

        stopCar.move();
        assertThat(stopCar.getPosition()).isEqualTo(0);

    }
}
