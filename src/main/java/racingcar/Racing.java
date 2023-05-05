package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> cars;

    Racing(String carNames, int trialCount) {
        this.cars = createCars(carNames, trialCount);
    }

    private static List<Car> createCars(String carNames, int trialCount) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for(String name : names) {
            cars.add(new Car(name, trialCount));
        }
        return cars;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
