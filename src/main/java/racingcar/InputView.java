package racingcar;

import java.util.Scanner;

public class InputView {

    private static RacingGame racingGame = new RacingGame();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int countCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int countTry = scanner.nextInt();

        racingGame.startRacing(countCar, countTry);
    }
}
