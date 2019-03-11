package racingcar;

import java.util.Scanner;

public class RacingGameApplication {

    static class RacingGameHelper {
        private static RacingGameBoard configure() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("자동차 대수는 몇 대 인가요? ");
            int numberOfCars = scanner.nextInt();

            System.out.println("시도할 회수는 몇 회 인가요? ");
            int numberOfTimes = scanner.nextInt();

            return new RacingGameBoard(numberOfCars, numberOfTimes);
        }
    }

    public static void main(String[] args) {

        RacingGameBoard racingGameBoard = RacingGameHelper.configure();

        racingGameBoard.play();
        racingGameBoard.show();
    }


}
