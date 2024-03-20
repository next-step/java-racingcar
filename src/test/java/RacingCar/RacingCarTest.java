package RacingCar;

import RacingGame.Domain.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class RacingCarTest {
    List<Car> carList = new ArrayList<Car>();
    Random random = new Random();

    @Test
    void MoveForward() {
        Car car = new Car();
        car.MoveForward(0);
        assertThat(car.GetMoveInfo()).isEqualTo(0);
        car.MoveForward(5);
        assertThat(car.GetMoveInfo()).isEqualTo(1);
    }

    @Test
    void MoveForward_여러_자동차() {
        for (int i = 0; i < 3; i++) {
            Car car = new Car();
            carList.add(car);
        }

        carList.get(0).MoveForward(3);
        carList.get(1).MoveForward(5);
        carList.get(2).MoveForward(6);

        assertThat(carList.get(0).GetMoveInfo()).isEqualTo(0);
        assertThat(carList.get(1).GetMoveInfo()).isEqualTo(1);
        assertThat(carList.get(2).GetMoveInfo()).isEqualTo(1);
    }

    @Test
    void GetMoveInfo() {
        Car car = new Car();
        assertThat(car.GetMoveInfo()).isEqualTo(0);
        car.MoveForward(5);
        assertThat(car.GetMoveInfo()).isEqualTo(1);
        car.MoveForward(3);
        assertThat(car.GetMoveInfo()).isEqualTo(1);
    }
}
