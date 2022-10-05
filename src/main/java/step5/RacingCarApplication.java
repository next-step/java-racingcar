package step5;

import java.util.ArrayList;
import java.util.List;
import step5.input.RacingCarInput;
import step5.output.RacingCarOutput;

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
