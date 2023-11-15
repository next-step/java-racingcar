package study.racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static study.racingCar.ResultView.printRacing;

class RacingModelTest {

    @Test
    void moveCar() {
        Car car = new Car();
        Position p = car.currentPosition();
        p.increase(3);
    }

    @Test
    void printTest() {
        System.out.println("!?!?!?!?:");
        printRacing(3);
        System.out.println();
    }
}