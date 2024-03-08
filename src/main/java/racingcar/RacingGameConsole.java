package racingcar;

import java.util.Scanner;

public class RacingGameConsole {

    private static final DrivingStrategyImpl DRIVING_STRATEGY = new DrivingStrategyImpl();
    private static final String WINNER_DELIMITER = ", ";

    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        String[] carNames = inputCarNames();
        int round = inputRound();

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.drive(round, DRIVING_STRATEGY);

        printResult(racingGame);
        printWinners(racingGame);
    }

    private void printResult(RacingGame racingGame) {
        System.out.println("\n실행 결과");
        System.out.println(racingGame.getResult());
    }

    private void printWinners(RacingGame racingGame) {
        System.out.printf("\n%s가 최종 우승했습니다.",
            String.join(WINNER_DELIMITER, racingGame.getWinnerNames()));
    }

    private String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(",");
    }

    private int inputRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
