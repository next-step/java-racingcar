package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final int CAR_INITIAL_POSITION = 1;

    private final List<Car> cars;

    public Game(List<CarName> carNames) {
        cars = new ArrayList<>();

        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void run() {
        cars.forEach(Car::move);
    }

    public List<CarName> getWinnerNames() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(CAR_INITIAL_POSITION);
        return cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

    }

    public List<Car> getCars() {
        return cars;
    }
}
