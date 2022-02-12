package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> moveCars(MoveStrategy moveStrategy) {
        List<Car> carAfterRace = new ArrayList<>();
        for (Car car : cars) {
            if (moveStrategy.canMove()) {
                car.moveForward();
            }
            carAfterRace.add(new Car(car.getCarName(), car.getPosition()));
        }
        return carAfterRace;
    }
}
