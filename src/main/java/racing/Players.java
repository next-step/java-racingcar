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

    public String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }

    private List<Car> insertCars(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
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
