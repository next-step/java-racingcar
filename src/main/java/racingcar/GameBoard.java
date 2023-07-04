package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {

    private final List<Car> cars;
    private final int tryCount;

    public GameBoard(List<String> carNames, int tryCount) {
        cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.tryCount = tryCount;
    }

    public void run(int tryCount) {
        if (tryCount != 0) {
            cars.forEach(Car::move);
        }
        Output.printExecutionResult(cars, tryCount);
        if (this.tryCount == tryCount) {
            Output.printWinner(getWinnerNames());
        }
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
}
