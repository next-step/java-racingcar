package racingcar.view;

import racingcar.RacingGame;
import util.StringUtils;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class InputView {
    private static final int SCAN_RETRY_COUNT = 3;
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public RacingGame scanRacingGameInfo() {
        int carNumber = getCarNumber();
        int attemptNumber = getAttemptNumber();

        RacingGame racingGame = RacingGame.of(carNumber, attemptNumber);

        scanner.close();
        return racingGame;
    }

    private int getCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        String value = scanner.nextLine();

        if (StringUtils.validateNumber(value)) {
            return Integer.parseInt(value);
        }
        return 0;
    }

    private int getAttemptNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String value = scanner.nextLine();

        if (StringUtils.validateNumber(value)) {
            return Integer.parseInt(value);
        }
        return 0;
    }

}
