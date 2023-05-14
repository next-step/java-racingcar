package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarCollection {
    private final List<Car> cars;

    public CarCollection() {
        this.cars = new ArrayList<>();
    }

    public CarCollection(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public int getCarCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
