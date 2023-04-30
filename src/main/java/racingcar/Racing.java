package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> cars;

    Racing(int carCount, int trialCount) {
        this.cars = createCars(carCount, trialCount);
    }

    private static List<Car> createCars(int carCount, int trialCount) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<carCount; i++) {
            cars.add(new Car(trialCount));
        }
        return cars;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
