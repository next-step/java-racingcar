package racingcar;

import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        scanner.close();

        RacingGame racingGame = new RacingGame();
        racingGame.start(numberOfCar, tryCount);
    }
}
