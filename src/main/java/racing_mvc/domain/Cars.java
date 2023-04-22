package racing_mvc.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(){
        this(new ArrayList<>());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    public void add(Car car) {
        cars.add(car);
    }

    public int count() {
        return cars.size();
    }

    public Car findOne(int carIndex) {
        return cars.get(carIndex);
    }

    public String findOneName(int carIndex) {
        return cars.get(carIndex).getName();
    }

    public boolean empty() {
        return cars.isEmpty();
    }
}
