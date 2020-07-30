package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private final List<Car> lacingCars;

    public RacingGame() {

        InputView inputView = new InputView();

        lacingCars = Stream.iterate(0, i -> i + 1)
                .limit(inputView.getNumberOfCars())
                .map(i -> new Car(inputView.getTryCount()))
                .collect(Collectors.toList());
    }

    public void start() {
        lacingCars.forEach(Car::moveAndStop);
    }

    public void printResult() {
        new ResultView(lacingCars).printResult();
    }
}
