package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.random.MovementStrategy;

public class Participants {

    private final List<Car> cars;

    public Participants(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Participants createCars(String[] names) {
        List<Car> cars = Arrays.stream(names)
            .map(name -> Car.from(name.trim()))
            .collect(Collectors.toList());
        return new Participants(cars);
    }

    public Participants race(MovementStrategy movementStrategy) {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars) {
            newCars.add(car.go(movementStrategy.generate()));
        }

        return new Participants(newCars);
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(cars);
    }
}
