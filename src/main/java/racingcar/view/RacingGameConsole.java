package racingcar.view;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.DrivingStrategy;
import racingcar.domain.RacingGame;
import racingcar.domain.SixtyPercentRandomDrivingStrategy;

public class RacingGameConsole {

    private static final DrivingStrategy DRIVING_STRATEGY = new SixtyPercentRandomDrivingStrategy();
    private static final String WINNER_DELIMITER = ", ";
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String WINNER_ANNOUNCEMENT_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        List<String> carNames = inputCarNames();
        int round = inputRound();

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.drive(round, DRIVING_STRATEGY);

        printLine();
        printResult(racingGame);

        printLine();
        printWinners(racingGame);
    }

    private void printLine() {
        System.out.println();
    }

    private void printResult(RacingGame racingGame) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(racingGame.result());
    }

    private void printWinners(RacingGame racingGame) {
        System.out.printf(WINNER_ANNOUNCEMENT_MESSAGE,
            String.join(WINNER_DELIMITER, racingGame.winnerNames()));
    }

    private List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return List.of(
            scanner.nextLine().split(CAR_NAMES_DELIMITER)
        );
    }

    private int inputRound() {
        System.out.println(INPUT_ROUND_MESSAGE);
        return scanner.nextInt();
    }
}
