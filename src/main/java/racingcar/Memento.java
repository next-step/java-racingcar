package racingcar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Memento {
    private List<Car> cars;

    public Memento() {
        cars = new LinkedList<>();
    }

    private Memento(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    private List<Car> cloneCars() {
        List<Car> cars = new LinkedList<>();
        for (Car car : this.cars) {
            cars.add(car.clone());
        }
        return cars;
    }

    public List<Car> getCars() {
        List<Car> cars = cloneCars();
        return Collections.unmodifiableList(
                new LinkedList<>(cars)
        );
    }

    @Override
    public Memento clone() {
        List<Car> cars = cloneCars();
        return new Memento(cars);
    }
}
