package step3RacingCarCompetition;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RacingCarCompetition {
    private final String go = "-";
    private final String stop = "";

    public void startRacing() {
        Scanner scanner = new Scanner(System.in);
        int totalNumberOfCars = InputCars.numberOfCars(scanner);
        int totalMovingCount = InputTryCount.movingTryCount(scanner);

        RacingCarInfo racingCarInfo = new RacingCarInfo(totalNumberOfCars);
        IntStream.range(0, totalMovingCount).forEachOrdered(movingTryCount -> {
            IntStream.range(0, totalNumberOfCars).forEachOrdered(numberOfCars -> {
                racingCarInfo.recordGoInRacingCarData(numberOfCars, moveStopDecision(randomNumber()));
                ResultView.printCurrentCarMovement(racingCarInfo.findRacingCarData(numberOfCars));
            });
            ResultView.printNewLine();
        });
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public String moveStopDecision(int randomNumber) {
        return randomNumber >= 4 ? go : stop;
    }
}
