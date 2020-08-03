package racingcar;

import racingcar.ui.RacingDataInput;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> racingCars = new ArrayList<>();
    private final RacingData racingData;
    private final Fuel fuel;

    public RacingGame(RacingDataInput racingDataInput, Fuel fuel) {

        racingData = racingDataInput.getRacingData();
        String[] names = racingData.getNames().split(",");

        this.fuel = fuel;

        for (int i = 0; i < racingData.getNumberOfCars(); i++) {
            racingCars.add(new Car(names[i]));
        }
    }

    public void start() {

        ResultView.lineFeed();
        ResultView.printStart();

        for (int i = 0; i < racingData.getTryCount(); i++) {
            moveCar(fuel);
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

    private void moveCar(Fuel fuel) {
        for (int i = 0; i < racingData.getNumberOfCars(); i++) {
            racingCars.get(i).moveAndStop(fuel);
        }
    }

    private void printCurrentStatus() {
        for (int i = 0; i < racingData.getNumberOfCars(); i++) {
            ResultView.printResult(racingCars.get(i));
        }
    }
}
