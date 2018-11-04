package racingGame;

import java.util.Scanner;

public class RacingGrameRunner {

    public static void main(String args[]) {
        RacingGameLogger logger = new RacingGameLogger();
        RacingGame racingGame = new RacingGame();
        racingGame.setLogger(logger);

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int cars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();

        scanner.close();

        System.out.println("\n실행 결과");
        racingGame.move(cars, times);
    }
}
