package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarsGenerator {

    public List<Car> generateCars(String inputCars) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCars.split(",");
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
        return cars;
    }
}
