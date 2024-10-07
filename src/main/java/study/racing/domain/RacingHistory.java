package study.racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingHistory {
    private final List<List<Car>> cars = new ArrayList<>();
    private int size;

    public void saveHistory(List<Car> cars) {
        this.cars.add(cars.stream()
                .map(car -> new Car(car.getCarNo(), car.getMoveCount()))
                .collect(Collectors.toList()));
    }

    public List<Car> getRacingHistory(int index) {
        return Collections.unmodifiableList(cars.get(index));
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
