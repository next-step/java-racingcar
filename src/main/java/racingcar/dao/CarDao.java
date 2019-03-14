package racingcar.dao;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private List<Car> cars = new ArrayList<>();

    public void save(List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
    }

    public List<Car> findAll() {
        return cars;
    }
}
