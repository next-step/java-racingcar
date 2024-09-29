package step3_RacingCar_Competition;

import java.util.Scanner;

public class RacingCarCompetition {
    public RacingCarInfo racingCarInfo;

    public void startRacing() {
        insertRacingCarData();


    }

    private void insertRacingCarData() {
        Scanner scanner = new Scanner(System.in);
        racingCarInfo = new RacingCarInfo(scanner.nextInt(), scanner.nextInt());
    }
}
