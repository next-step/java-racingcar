package step4;

import java.util.ArrayList;
import step4.input.RacingCarInput;
import step4.output.RacingCarOutput;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarOutput.printCarNames();
        String[] carNames = RacingCarInput.carNames();
        int carCount = carNames.length;
        RacingCarOutput.printTryCount();
        int tryCount = RacingCarInput.tryCount();

        List<Car> cars = CarFactory.createCar(carNames);

        RacingCarOutput.printStartMessage();

        List<RacingResult> racingResults = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            racingResults.addAll(RacingGame.start(cars));
        }

        RacingCarOutput.printRacingResults(racingResults, carCount);

        String winner = RacingWinner.chooseWinner(cars);
        RacingCarOutput.printWinner(winner);
    }
}
