package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> values;

    public Cars(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("자동차 대수는 1이상이어야 합니다.");
        }

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

    public int size() {
        return this.values.size();
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
