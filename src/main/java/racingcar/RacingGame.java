package racingcar;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class RacingGame {

    private int countOfRacingCar;
    private int countOfRacing;
    private static String RACING_STATE_EXPRESSION = "-";

    public static void  main(String[] args) {
        RacingGame game = new RacingGame();
        game.readyRacingGame();
        game.startRacingGame();
    }

    public void readyRacingGame() {
        Scanner scan = new Scanner(System.in);
        System.out.println("자동차 댓수는 몇대인가요?");
        countOfRacingCar = toInt(scan.nextLine());
        System.out.println("시도할 횟수는 몇대인가요?");
        countOfRacing = toInt(scan.nextLine());
    }

    public void startRacingGame() {
        RacingTrac racingTrac = new RacingTrac();
        RacingCar[] result = RacingTrac.getGameResult(countOfRacingCar, countOfRacing);
        for(int i=1;i<=countOfRacing;i++) {
            viewResult(result, i);
            System.out.println();
        }
    }
    public void viewResult(RacingCar[] racingCar, int turnOfRacing) {
        for(int i=0;i<racingCar.length;i++) {
            RacingCar car = racingCar[i];
            viewCar(racingCar[i],turnOfRacing);
        }
    }

    private void viewCar(RacingCar racingCar, int turnOfRacing) {
        int sumOfRacingLength = 0;

        for(int i=1;i<=turnOfRacing;i++) {
            sumOfRacingLength += racingCar.getRacingResult(i);
        }

        for(int i=0;i<=sumOfRacingLength;i++) {
            System.out.print(RACING_STATE_EXPRESSION);
        }

        System.out.println();
    }


    private int toInt(String nextLine) {
        return Integer.parseInt(nextLine);
    }
}
