package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static final int DEFAULT_CAR_POSITION = 0;

    private final List<Car> cars;

    public Cars(int carSize) {
        this.cars = generateCar(carSize);
    }

    private List<Car> generateCar(int carSize) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carSize; i++) {
            cars.add(new Car(DEFAULT_CAR_POSITION));
        }
        return cars;
    }

    public List<Car> getCar() {
        return Collections.unmodifiableList(cars);
    }

}
