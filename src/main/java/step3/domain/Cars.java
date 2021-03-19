package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int numberOfCars, String scoreSymbol) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(scoreSymbol));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
