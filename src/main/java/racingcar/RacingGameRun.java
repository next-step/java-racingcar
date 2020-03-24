package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingGameRun {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.next();

        RacingGame racingGame = new RacingGame(carNames);
        RacingGameView racingGameView = new RacingGameView(racingGame);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int runCount = scanner.nextInt();

        List<Cars> carLoos = racingGame.startRacing(runCount);
        System.out.println("실행 결과");

        racingGameView.viewResult(carLoos);
        racingGameView.viewWinners(carLoos.get(carLoos.size() - 1));
    }
}
