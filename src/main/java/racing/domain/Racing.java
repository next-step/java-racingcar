package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racing.utils.MovingStrategy;
import racing.utils.RandomValueMovingStrategy;

public class Racing {

    private List<Car> cars;

    private static final MovingStrategy MOVING_STRATEGY = new RandomValueMovingStrategy();

    public Racing(List<String> names) {
        this.cars = names.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public List<Car> roundStart() {
        this.cars.forEach(car -> car.move(MOVING_STRATEGY));
        return getCars();
    }

    public List<String> winners() {
        int maxMove = maxDistance();
        return cars.stream()
            .filter(car -> car.isWinner(maxMove))
            .map(car -> car.getName())
            .collect(Collectors.toList());
    }

    private int maxDistance() {
        return cars.stream()
            .max(Comparator.comparingInt(Car::getDistance))
            .get()
            .getDistance();
    }


}
