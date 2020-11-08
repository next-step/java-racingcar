package racingcar.domain.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * NOTE: Memento(세이브)의 단위가 List<Car>가 아니라,
 * Serialized 된 csv 혹은 json String 이 될 수도 있으므로,
 * Memento 는 Car 의 컬렉션이 아니라,
 * 별도의 model 로 분류되는 게 합당하다.
 */
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
