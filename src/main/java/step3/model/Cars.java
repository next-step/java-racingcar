package step3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final String DELIMITER = ",";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String inputValue) {
        String[] carNames = inputValue.split(DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName)));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveOrStop();
        }
    }
}
