package race.model;

import racing.model.Car;
import racing.model.Cars;
import racing.model.MovingStrategy;
import racing.model.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestCars extends Cars {

    private List<Car> carList = new ArrayList<>();

    public void prepareCars(List<Car> cars) {
        carList = cars;
        super.prepareCars(cars);
    }


    public void carsMove(MovingStrategy movingStrategy) {
        carList.forEach(car -> car.run(movingStrategy));
    }

}
