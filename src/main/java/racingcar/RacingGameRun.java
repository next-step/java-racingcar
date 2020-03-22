package racingcar;

import java.util.Scanner;

public class RacingGameRun {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");

        Scanner scanner = new Scanner(System.in);
        int carTotalCount = scanner.nextInt();

        RacingGame racingGame = new RacingGame(carTotalCount);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int runCount = scanner.nextInt();

        System.out.println("실행 결과");
        racingGame.startRacing(runCount);
    }
}
