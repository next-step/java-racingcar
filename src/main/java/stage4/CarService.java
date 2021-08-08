package stage4;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public List<ResultValue> startRace(String[] carNames, int numberOfTries) {
        final List<Car> cars = init(carNames);

        List<ResultValue> results = new ArrayList<>();
        for (int i = 0; i < numberOfTries; i++) {
            for (Car car : cars) {
                final int forwardCondition = car.getForwardCondition();
                car.tryForward(forwardCondition);
                results.add(new ResultValue(car.getName(), car.getStatus()));
            }
        }
        return results;
    }

    private List<Car> init(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}