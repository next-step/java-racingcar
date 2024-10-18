package racinggamewinner;

import racinggamewinner.random.RacingCarRandomGenerator;
import racinggamewinner.random.RandomGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String carNames = InputView.nameOfCars(scanner);
        int movingTryCount = InputView.movingTryCount(scanner);

        Cars racingCars = Cars.registerCars(carNames);

        RandomGenerator randomGenerator = new RacingCarRandomGenerator();
        ResultView.printPreview();
        racingCars.viewRacing(movingTryCount, randomGenerator);

        ResultView.printTotalCarPosition(racingCars.carNameAndPositions());
        ResultView.printWinner(racingCars.findWinner());

    }
}
