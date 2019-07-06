package racing;

import org.junit.jupiter.api.BeforeEach;
import racing.model.Car;
import racing.model.CarName;
import racing.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(Car.of(new CarName("henrry")));
        carList.add(Car.of(new CarName("javajigi")));
        carList.add(Car.of(new CarName("helloworld")));

        Car winnerCar = Car.of(new CarName("poison"));
        winnerCar.move(Car.MOVE_CONDITION);
        winnerCar.move(Car.MOVE_CONDITION);

        Car winnerCar2 = Car.of(new CarName("twoCar"));
        winnerCar2.move(Car.MOVE_CONDITION);
        winnerCar2.move(Car.MOVE_CONDITION);

        carList.add(winnerCar);
        carList.add(winnerCar2);

        cars = new Cars(carList);
    }
}

