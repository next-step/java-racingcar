package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public List<Car> getAll() {
        return cars;
    }
}
