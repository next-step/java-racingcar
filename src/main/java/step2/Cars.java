package step2;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void createCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(1, carName));
        }
    }

    public void add(Car car) {
        cars.add(car);
    }

    public int extractNumberOfCars() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public String[] getCarNames() {
        List<String> carNames = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.getName());
        }

        return carNames.toArray(new String[carNames.size()]);
    }
}
