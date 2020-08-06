package racingcar.domain;

import racingcar.ui.RacingDataInput;
import racingcar.ui.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> racingCars;
    private final RacingData racingData;

    public RacingGame(RacingDataInput racingDataInput, Engine engine) {

        racingData = racingDataInput.getRacingData();
        racingCars = Arrays.stream(racingData.getNames())
                .map((name) -> new Car(engine, name))
                .collect(Collectors.toList());
    }

    public void start() {

        ResultView.lineFeed();
        ResultView.printStart();

        for (int i = 0; i < racingData.getTryCount(); i++) {
            moveCar();
            printCurrentStatus();

            ResultView.lineFeed();
        }
    }

    public void end() {
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

    private void printCurrentStatus() {
        for (int i = 0; i < racingData.getNumberOfCars(); i++) {
            ResultView.printResult(racingCars.get(i));
        }
    }
}
