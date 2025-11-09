package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> values;

    public Cars(int count) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        this.values = cars;
    }

    public void moveAll(RandomNumber randomNumber) {
        for (Car car : values) {
            car.move(randomNumber.generate());
        }
    }

    public List<Car> getValues() {
        return List.copyOf(this.values);
    }

    public List<Integer> getDistances() {
        List<Integer> distances = new ArrayList<>();

        for (Car car : values) {
            distances.add(car.getDistance());
        }

        return distances;
    }
}
