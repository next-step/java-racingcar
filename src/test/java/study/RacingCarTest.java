package study;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    private RacingCar racingCar = new RacingCar();

    @Test
    void 주어진횟수동안_n대의자동차는_전진또는멈출수있다() {
        int carCount = 3;
        int moveCount = 4;
        racingCar.race(racingCar.makeRacingCar(carCount), moveCount);
    }

    @Test
    void 사용자는몇대의자동차로몇번의이동을할것인지를입력할수있다() {
        int carCount =3;
        List<Car> cars = racingCar.makeRacingCar(carCount);
        assertThat(cars).hasSize(carCount);
    }

    @Test
    void 전진하는조건은0에서9사이에서random값을구한후_random값이4이상일경우이다() {
        Car car = new Car("car", 0);
        car.move();
    }

    @Test
    void 자동차의상태를화면에출력한다() {
        Car car1 = new Car("car", 0);
        Car car2 = new Car("car",2);
        Car car3 = new Car("car",3);
        car1.print();
        car2.print();
        car3.print();
    }

}
