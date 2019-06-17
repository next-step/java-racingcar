package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            Car car = Car.create(name);
            cars.add(car);
        }
    }

    public List<Integer> move() {
        List<Integer> positions = new ArrayList<>();

        for (Car car : cars) {
            int position = car.move();
            positions.add(position);
        }

        return positions;
    }
}
