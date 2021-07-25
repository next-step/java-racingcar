package race;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public static Cars of(Condition condition) {
        return new Cars(condition);
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public List<Integer> getDistanceByRound(int round) {
        return cars.stream()
                .map(car-> car.getDistance(round))
                .collect(Collectors.toList());
    }

    private Cars(Condition condition) {
        for (int i = 0; i < condition.getCarCount(); i++) {
            cars.add(Car.of(condition.getTryCount()));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
