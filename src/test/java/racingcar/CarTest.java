package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.NumGenerator;

import static org.assertj.core.api.Assertions.assertThat;



public class CarTest {
    private Car goingCar;
    private Car stoppdCar;

    @BeforeEach
    void setUp() {
        NumGenerator goingNum = new FixedNumGenerator(5);
        NumGenerator stopNum = new FixedNumGenerator(3);
        goingCar = new Car("alice", 0, goingNum);
        stoppdCar = new Car("alice", 0, stopNum);
    }

    @Test
    void testGoCar() {
        goingCar.move();
        assertThat(goingCar.getPosition()).isEqualTo(1);

        goingCar.move();
        goingCar.move();
        assertThat(goingCar.getPosition()).isEqualTo(3);
    }

    @Test
    void testStopCar(){
        stoppdCar.move();
        assertThat(stoppdCar.getPosition()).isEqualTo(0);
    }
}
