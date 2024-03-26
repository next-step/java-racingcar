package RacingCar;

import RacingGame.Domain.Car;
import RacingGame.Domain.CarManager;
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
        BigNumberStrategy bigNumberStragey = new BigNumberStrategy();
        SmallNumberStrategy smallNumberStrategy = new SmallNumberStrategy();

        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");
        car1.setStrategy(smallNumberStrategy);
        car1.moveForward();
        assertThat(car1.getMoveInfo()).isEqualTo(0);

        car2.setStrategy(bigNumberStragey);
        car2.moveForward();
        assertThat(car2.getMoveInfo()).isEqualTo(1);

        car3.setStrategy(bigNumberStragey);
        car3.moveForward();
        assertThat(car3.getMoveInfo()).isEqualTo(1);
    }

    @Test
    void GetMoveInfo() {
        Car car = new Car("pobi");
        car.setStrategy(new BigNumberStrategy());
        assertThat(car.getMoveInfo()).isEqualTo(0);
        car.moveForward();
        assertThat(car.getMoveInfo()).isEqualTo(1);
        car.moveForward();
        assertThat(car.getMoveInfo()).isEqualTo(2);
    }

    @Test
    void GetName() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void GetCarList() {
        String[] names = {"pobi", "crong", "honux"};
        CarManager carManager = new CarManager(5, names, new BigNumberStrategy());
        List<Car> carList = carManager.getCarList();
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("crong");
        assertThat(carList.get(2).getName()).isEqualTo("honux");
    }

    @Test
    void MoveForwardCars() {
        String[] names = {"pobi"};
        CarManager carManager = new CarManager(5, names, new BigNumberStrategy());
        List<Car> carList = carManager.getCarList();
        carManager.moveForwardCars();
        carList = carManager.getCarList();
        assertThat(carList.get(0).getMoveInfo()).isEqualTo(5);
    }

    @Test
    void GetWinners() {
        String[] names = {"pobi", "crong", "honux"};
        CarManager carManager = new CarManager(5, names, new BigNumberStrategy());
        List<Car> carList = carManager.getCarList();
        carManager.moveForwardCars();
        assertThat(carManager.getWinners().get(0)).isEqualTo("pobi");
        assertThat(carManager.getWinners().get(1)).isEqualTo("crong");
        assertThat(carManager.getWinners().get(2)).isEqualTo("honux");
    }
}
