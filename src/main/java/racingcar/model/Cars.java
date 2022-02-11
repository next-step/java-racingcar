package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> createdCars) {
        cars = new ArrayList<>(createdCars);
    }

    public List<Car> moveCars(MoveStrategy moveStrategy) {
        List<Car> carAfterRace = new ArrayList<>();
        for (Car car : cars) {
            if (moveStrategy.moveOrNot()) {
                car.moveForward();
            }
            carAfterRace.add(new Car(car.getCarName(), car.getPosition()));
        }
        return carAfterRace;
    }
}
