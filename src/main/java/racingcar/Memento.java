package racingcar;

import java.util.LinkedList;
import java.util.List;

public class Memento {
    private List<Car> cars;

    public Memento() {
        this.cars = new LinkedList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        List<Car> cars = new LinkedList<>();
        for (Car car : this.cars) {
            cars.add(new Car(car));
        }
        return cars;
    }
}
