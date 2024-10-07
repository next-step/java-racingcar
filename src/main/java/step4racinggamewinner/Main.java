package step4racinggamewinner;

import step4racinggamewinner.random.RacingCarRandomGenerator;
import step4racinggamewinner.random.RandomGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String carNames = InputView.nameOfCars(scanner);
        int movingTryCount = InputView.movingTryCount(scanner);

        Cars racingCars = new Cars(carNames);
        RandomGenerator randomGenerator = new RacingCarRandomGenerator();
        ResultView.printPreview();
        racingCars.viewRacing(movingTryCount, randomGenerator);

        ResultView.printTotalCarPosition(racingCars.carNameAndPosition());
        ResultView.printWinner(racingCars.findWinner());

    }
}
