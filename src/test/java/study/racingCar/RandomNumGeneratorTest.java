package study.racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static study.racingCar.ResultView.printRacing;

class RandomNumGeneratorTest {

    @Test
    void moveCar() {
        Car car = new Car();
        car.move(5);
        assertThat(car.currentPosition()).isEqualTo(new Position(1));
    }

}