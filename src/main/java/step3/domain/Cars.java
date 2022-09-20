package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }

    public Cars addCar(Car car) {
        List<Car> copyCarList = new ArrayList<>(cars);
        copyCarList.add(car);
        return new Cars(copyCarList);
    }

    public List<Car> cars() {
        return new ArrayList<>(cars);
    }
}
