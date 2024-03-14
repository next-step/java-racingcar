package RacingCar;

import RacingGame.Domain.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingCarTest {
    List<Car> carList = new ArrayList<Car>();
    Random random = new Random();

    @Test
    void MoveForward() {
        Car car = new Car();
        int rval = random.nextInt(10);
        car.MoveForward(rval);
        if (rval > 4) assertThat(car.GetMoveInfo()).isEqualTo(1);
        else assertThat(car.GetMoveInfo()).isEqualTo(0);
    }

    @Test
    void MoveForward_여러번() {
        for (int i = 0; i < 3; i++) {
            Car car = new Car();
            carList.add(car);
        }

        int rval = 1;
        for (int i = 0; i < 5; i++) {
            for (Car car : carList) {
                car.MoveForward(rval++);
            }
        }

        assertThat(carList.get(0).GetMoveInfo()).isEqualTo(3);
        assertThat(carList.get(1).GetMoveInfo()).isEqualTo(4);
        assertThat(carList.get(2).GetMoveInfo()).isEqualTo(4);
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
