package step3_RacingCar_Competition;

import java.util.Random;
import java.util.Scanner;

public class RacingCarCompetition {
    private final boolean GO = true;
    private final boolean STOP = false;

    public void startRacing() {
        insertRacingCarData();
        RacingCarInfo racingCarInfo = insertRacingCarData();

        for (int movingTryCount = 0; movingTryCount < racingCarInfo.MovingTryCount(); movingTryCount++) {
            for (int carNumber = 1; carNumber <= racingCarInfo.NumberOfCars(); carNumber++) {

                if (GO == moveStopDecision(randomNumber())) {
                    racingCarInfo.recordGoInRacingCarData(carNumber);
                }
            }
        }

    }

    private RacingCarInfo insertRacingCarData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int movingTryCount = scanner.nextInt();

        return new RacingCarInfo(numberOfCars, movingTryCount);
    }

    /**
     * TODO private로 하고 싶은데 테스트하자니 지양됨.
     * 그렇다고 public으로 하기는 싫은데 고민.
     */
    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean moveStopDecision(int randomNumber) {
        return randomNumber >= 4 ? GO : STOP;
    }
}
