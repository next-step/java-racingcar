package racingcar;

import java.util.Scanner;

public class RacingGameConsole {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carAmount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int round = scanner.nextInt();

        DrivingStrategyImpl drivingStrategy = new DrivingStrategyImpl();
        RacingGame racingGame = new RacingGame(drivingStrategy, carAmount);
        racingGame.drive(round);

        System.out.println("\n실행 결과");
        System.out.println(racingGame.getResult());
    }
}
