package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.random.RandomNumber;

public class Cars {
    private static final int MIN_CAR_COUNT = 1;

    private final List<Car> values;

    public Cars(List<String> names) {
        validateCount(names.size());
        validateUnique(names);

        this.values = createCars(names);
    }

    private void validateCount(int count) {
        if (isInvalidCount(count)) {
            throw new IllegalArgumentException("자동차 대수는 1이상이어야 합니다.");
        }
    }

    private boolean isInvalidCount(int count) {
        return count < MIN_CAR_COUNT;
    }

    private void validateUnique(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public void moveAll(RandomNumber randomNumber) {
        for (Car car : values) {
            car.move(randomNumber.generate());
        }
    }

    public int size() {
        return this.values.size();
    }

    public List<CarSnapshot> toSnapshots() {
        List<CarSnapshot> snapshots = new ArrayList<>();

        for (Car car : values) {
            snapshots.add(car.toSnapshot());
        }

        return snapshots;
    }

    public List<Integer> getDistances() {
        List<Integer> distances = new ArrayList<>();

        for (Car car : values) {
            distances.add(car.getDistance());
        }

        return distances;
    }
}
