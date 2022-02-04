package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.random.MovementGenerator;
import racingcar.domain.random.MovementStrategy;

public class Participants {

    private static final String DELIMITER = ", ";


    private final List<Car> cars;

    public Participants(List<Car> cars) {
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
            newCars.add(car.go(movementStrategy));
        }

        return new Participants(newCars);
    }

    public String findWinners() {
        Collections.sort(cars, (car1, car2) -> car2.position - car1.position);

        String winners = cars.stream()
            .filter(car -> car.isSamePosition(cars.get(0)))
            .map(Car::getName)
            .collect(Collectors.joining(DELIMITER));

        return winners;
    }

    public List<Car> getParticipants() {
        return this.cars;
    }
}
