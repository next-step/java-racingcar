package racingcar.view;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.DrivingStrategy;
import racingcar.domain.RacingGame;
import racingcar.domain.SixtyPercentRandomDrivingStrategy;

public class RacingGameConsole {

    private static final DrivingStrategy DRIVING_STRATEGY = new SixtyPercentRandomDrivingStrategy();
    private static final String WINNER_DELIMITER = ", ";

    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        List<String> carNames = inputCarNames();
        int round = inputRound();

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.drive(round, DRIVING_STRATEGY);

        printResult(racingGame);
        printWinners(racingGame);
    }

    private void printResult(RacingGame racingGame) {
        System.out.println("\n실행 결과");
        System.out.println(racingGame.result());
    }

    private void printWinners(RacingGame racingGame) {
        System.out.printf("\n%s가 최종 우승했습니다.",
            String.join(WINNER_DELIMITER, racingGame.winnerNames()));
    }

    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return List.of(
            scanner.nextLine().split(",")
        );
    }

    private int inputRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
