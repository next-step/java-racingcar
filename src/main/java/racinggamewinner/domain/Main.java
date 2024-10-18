package racinggamewinner.domain;

import racinggamewinner.random.RacingCarRandomGenerator;
import racinggamewinner.random.RandomGenerator;
import racinggamewinner.view.InputView;
import racinggamewinner.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String carNames = InputView.nameOfCars(scanner);
        int maxMovingCount = InputView.movingTryCount(scanner);

        Cars racingCars = Cars.registerCars(carNames);

        RandomGenerator randomGenerator = new RacingCarRandomGenerator();
        ResultView.printPreview();

        for (int i = 0; i < maxMovingCount; i++) {
            racingCars.raceOneRound(randomGenerator);
            ResultView.printTotalCarPosition(racingCars.carNameAndPositions());
        }

        ResultView.printTotalCarPosition(racingCars.carNameAndPositions());
        ResultView.printWinner(racingCars.findWinner());

    }
}
