package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarsGenerator {

    public Cars generateCars(String inputCars) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCars.split(",");
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
        return Cars.of(cars);
    }
}
