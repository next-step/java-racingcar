package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {

    private final List<Car> cars;

    public GameBoard(List<String> carNames) {
        cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void run() {
        cars.forEach(Car::move);
    }

    public List<String> getWinnerNames() {
        int maxIndex = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(1);
        return cars.stream()
                .filter(c -> c.getPosition() == maxIndex)
                .map(Car::getName)
                .collect(Collectors.toList());

    }

    public List<Car> getCars() {
        return cars;
    }
}
