package step3RacingCarCompetition;

import java.util.List;
import java.util.Scanner;

public class RacingCarCompetition {
    final static int ENDRANGE = 10;

    public void startRacing() {
        Scanner scanner = new Scanner(System.in);
        RandomGenerator randomGenerator = new RandomNumber(ENDRANGE);
        int totalNumberOfCars = InputCars.numberOfCars(scanner);
        int totalMovingCount = InputTryCount.movingTryCount(scanner);
        RacingCarInfo racingCarInfo = new RacingCarInfo(totalNumberOfCars, totalMovingCount, randomGenerator);

        printCarsMovingData(totalMovingCount, racingCarInfo);
    }

    private void printCarsMovingData(int totalMovingCount, RacingCarInfo racingCarInfo) {
        ResultView.printPreview();
        for (int movingCount = 0; movingCount < totalMovingCount; movingCount++) {
            List<String> currentCarsMovingData = racingCarInfo.findEachRoundRacingCarData(movingCount);
            ResultView.printCurrentCarMovement(currentCarsMovingData);
        }
    }


}
