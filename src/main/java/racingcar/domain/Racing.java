package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final int round;
    private final List<Car> cars;
    private final List<List<Car>> history = new ArrayList<>();

    private static final int DEFAULT_ROUND = 5;
    private static final String SPLIT_REGEX = ",";

    public Racing(int round, Car... cars) {
        this(round, Arrays.asList(cars));
    }

    public Racing(int round, String carNames) {
        this.round = round;
        this.cars = stringToList(carNames);
    }

    private List<Car> stringToList(String carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames.split(SPLIT_REGEX)) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public Racing(int round, List<Car> cars) {
        this.round = round;
        this.cars = cars;
    }

    public List<Car> winners() {
        Car winnerCar = this.cars.stream()
                .max(Car::compareTo)
                .get();

        return this.cars.stream()
                .filter(each -> each.samePosition(winnerCar))
                .collect(Collectors.toList());
    }

    public void start(MovePredicate movePredicate) {
        for (int i = 0; i < this.round; i++) {
            race(movePredicate);
            writeHistory();
        }
    }

    private void race(MovePredicate movePredicate) {
        for (Car car : cars) {
            car.move(movePredicate);
        }
    }

    private void writeHistory() {
        this.history.add(
                this.cars.stream()
                        .map(car -> car.of())
                        .collect(Collectors.toList())
        );
    }

    public List<List<Car>> record() {
        return this.history;
    }
}
