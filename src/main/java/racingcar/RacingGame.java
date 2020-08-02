package racingcar;

import racingcar.ui.RacingDataInput;
import racingcar.ui.ScannerInput;
import racingcar.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private final List<Car> lacingCars;
    private final RacingData racingData;

    public RacingGame(RacingDataInput racingDataInput) {

        racingData = racingDataInput.getRacingData();

        lacingCars = Stream.iterate(0, i -> i + 1)
                .limit(racingData.getNumberOfCars())
                .map(i -> new Car())
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

    private void moveCar() {
        for (int i = 0; i < racingData.getNumberOfCars(); i++) {
            lacingCars.get(i).moveAndStop();
        }
    }

    private void printCurrentStatus() {
        for (int i = 0; i < racingData.getNumberOfCars(); i++) {
            ResultView.printResult(lacingCars.get(i));
        }
    }
}
