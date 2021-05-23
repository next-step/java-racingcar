package racing;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Car> cars;

    public Players(List<Car> cars) {
        this.cars = cars;
    }

    public Players(String carNames) {
        this.cars = insertCars(splitCarNames(carNames));
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }

    private List<Car> insertCars(String[] carNames) {
        List<Car> temporaryCars = new ArrayList<>();

        for (String carName : carNames) {
            temporaryCars.add(new Car(carName));
        }

        return temporaryCars;
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.getName());
        }

        return carNames;
    }

    public List<Car> getCars() {
        return cars;
    }
}
