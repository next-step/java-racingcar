package racingcar;

import java.util.Scanner;

public class RacingGameConsole {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(",");

        System.out.println("시도할 회수는 몇 회 인가요?");
        int round = scanner.nextInt();

        DrivingStrategyImpl drivingStrategy = new DrivingStrategyImpl();
        RacingGame racingGame = new RacingGame(drivingStrategy, carNames);
        racingGame.drive(round);

        System.out.println("\n실행 결과");
        System.out.println(racingGame.getResult());
    }
}
