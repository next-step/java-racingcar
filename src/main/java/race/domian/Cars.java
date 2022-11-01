package race.domian;

import java.util.ArrayList;
import java.util.List;
import race.strategy.MoveStrategy;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }
}
