package RacingCar;

import RacingGame.Domain.BigNumberStrategy;
import RacingGame.Domain.Car;
import RacingGame.Domain.CarManager;
import RacingGame.Domain.SmallNumberStrategy;
import org.junit.jupiter.api.DisplayName;
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
        BigNumberStrategy bigNumberStragey = new BigNumberStrategy();
        SmallNumberStrategy smallNumberStrategy = new SmallNumberStrategy();

        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");
        car1.SetStrategy(smallNumberStrategy);
        car1.MoveForward();
        assertThat(car1.GetMoveInfo()).isEqualTo(0);

        car2.SetStrategy(bigNumberStragey);
        car2.MoveForward();
        assertThat(car2.GetMoveInfo()).isEqualTo(1);

        car3.SetStrategy(bigNumberStragey);
        car3.MoveForward();
        assertThat(car3.GetMoveInfo()).isEqualTo(1);
    }

    @Test
    void GetMoveInfo() {
        Car car = new Car("pobi");
        car.SetStrategy(new BigNumberStrategy());
        assertThat(car.GetMoveInfo()).isEqualTo(0);
        car.MoveForward();
        assertThat(car.GetMoveInfo()).isEqualTo(1);
        car.MoveForward();
        assertThat(car.GetMoveInfo()).isEqualTo(2);
    }

    @Test
    void GetName() {
        Car car = new Car("pobi");
        assertThat(car.GetName()).isEqualTo("pobi");
    }

    @Test
    void GetCarList() {
        String[] names = {"pobi", "crong", "honux"};
        CarManager carManager = new CarManager(5, names);
        List<Car> carList = carManager.GetCarList();
        assertThat(carList.get(0).GetName()).isEqualTo("pobi");
        assertThat(carList.get(1).GetName()).isEqualTo("crong");
        assertThat(carList.get(2).GetName()).isEqualTo("honux");
    }

    @Test
    void MoveForwardCars() {
        String[] names = {"pobi"};
        CarManager carManager = new CarManager(5, names);
        List<Car> carList = carManager.GetCarList();
        carList.get(0).SetStrategy(new BigNumberStrategy());
        carManager.MoveForwardCars(5);
        carList = carManager.GetCarList();
        assertThat(carList.get(0).GetMoveInfo()).isEqualTo(5);
    }

    @Test
    void GetWinners() {
        BigNumberStrategy bigNumberStragey = new BigNumberStrategy();
        SmallNumberStrategy smallNumberStrategy = new SmallNumberStrategy();

        String[] names = {"pobi", "crong", "honux"};
        CarManager carManager = new CarManager(5, names);
        List<Car> carList = carManager.GetCarList();
        carList.get(0).SetStrategy(bigNumberStragey);
        carList.get(1).SetStrategy(smallNumberStrategy);
        carList.get(2).SetStrategy(smallNumberStrategy);

        carManager.MoveForwardCars(5);
        assertThat(carManager.GetWinners().get(0)).isEqualTo("pobi");
    }
}
