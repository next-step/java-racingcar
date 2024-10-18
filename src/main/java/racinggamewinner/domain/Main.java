package racinggamewinner.domain;

import racinggamewinner.random.RacingCarRandomGenerator;
import racinggamewinner.random.RandomStrategy;
import racinggamewinner.view.InputView;
import racinggamewinner.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String carNames = InputView.nameOfCars(scanner);
        int maxMovingCount = InputView.movingTryCount(scanner);

        Cars racingCars = Cars.registerCars(carNames);
        ResultView.printPreview();
        RandomStrategy randomStrategy = new RandomStrategy(new RacingCarRandomGenerator());

        for (int i = 0; i < maxMovingCount; i++) {
            racingCars.raceOneRound(randomStrategy);
            ResultView.printTotalCarPosition(racingCars.carNameAndPositions());
        }

        ResultView.printTotalCarPosition(racingCars.carNameAndPositions());
        ResultView.printWinner(racingCars.findWinner());

    }
}
