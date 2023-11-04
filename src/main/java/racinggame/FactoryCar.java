package racinggame;

import java.util.ArrayList;
import java.util.List;

public class FactoryCar {

    private static final int DEFAULT_CAR_POSITION = 0;

    public List<Car> generateCar(int carSize, GenerateNumber generateNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carSize; i++) {
            cars.add(new Car(DEFAULT_CAR_POSITION, generateNumber));
        }
        return cars;
    }

}
