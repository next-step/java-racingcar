package racingcar.domain;

import racingcar.ui.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> racingCars;
    private final RacingData racingData;

    public RacingGame(RacingData racingData, Engine engine) {

        this.racingData = racingData;
        racingCars = Arrays.stream(racingData.getNames())
                .map((name) -> new Car(engine, name))
                .collect(Collectors.toList());
    }

    public void run() {

        ResultView.lineFeed();
        ResultView.printStart();

        for (int i = 0; i < racingData.getTryCount(); i++) {
            moveCar();
            ResultView.printSetResult(racingData, racingCars);
            ResultView.lineFeed();
        }
    }

    public void result() {
        ResultView.printWinnerNames(getWinnerNames());
    }

    public String getWinnerNames() {

        OptionalInt maxMoveCount = racingCars.stream()
                .mapToInt(Car::getMoveCount)
                .reduce(Integer::max);

        int max = maxMoveCount.orElse(0);
        return racingCars.stream()
                .filter(car -> car.getMoveCount() == max)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private void moveCar() {
        for (int i = 0; i < racingData.getNumberOfCars(); i++) {
            racingCars.get(i).moveAndStop();
        }
    }
}
