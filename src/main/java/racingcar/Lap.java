package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Lap {
    private List<Integer> distances = new ArrayList<>();

    public Lap(List<Car> cars) {
        for (Car car : cars) {
            distances.add(car.getDistance());
        }
    }

    public List<Integer> getDistances() {
        return distances;
    }
}
