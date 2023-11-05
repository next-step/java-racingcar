package carRacing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Integer> getDistances() {
        List<Integer> list = new ArrayList<>();
        for (Car car : cars) {
            list.add(car.getDistance());
        }
        return list;
    }
}
