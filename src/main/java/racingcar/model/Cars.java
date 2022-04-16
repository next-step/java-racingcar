package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;

public final class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validate(List<Car> cars) {
        Objects.requireNonNull(cars, "전달된 리스트가 올바르지 않습니다 : Cars is null");

        if (cars.isEmpty()) {
            throw new IllegalArgumentException("전달된 리스트가 올바르지 않습니다 : Cars is empty");
        }
    }

    public Cars play(MovingStrategy movingStrategy) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.move(movingStrategy));
        }
        return new Cars(result);
    }

    public List<CarName> names() {
        return cars.stream()
                .map(Car::name)
                .collect(Collectors.toList());
    }

    public List<Distance> states() {
        return cars.stream()
                .map(Car::state)
                .collect(Collectors.toList());
    }

    public static List<CarName> findWinner(int count, List<CarName> names, List<Distance> states) {
        int maxState = Distance.ZERO.value();
        Queue<CarName> candidates = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            maxState = updateCandidate(maxState, candidates, names.get(i), states.get(i).value());
        }

        return candidates.stream().collect(Collectors.toList());
    }

    private static int updateCandidate(int maxState, Queue<CarName> candidates, CarName name, int state) {
        if (maxState > state) {
            return maxState;
        }

        if (maxState == state) {
            candidates.add(name);
            return maxState;
        }

        candidates.clear();
        candidates.add(name);
        return state;
    }
}
