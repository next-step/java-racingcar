package racingcar.view;

import racingcar.RacingGame;
import util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class InputView {
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public RacingGame scanRacingGameInfo() {
        List<String> carNames = getCarNumber();
        int attemptNumber = getAttemptNumber();

        RacingGame racingGame = RacingGame.of(carNames, attemptNumber);

        scanner.close();
        return racingGame;
    }

    private List<String> getCarNumber() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();

        return Arrays.asList(value.split(","));
    }

    private int getAttemptNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String value = scanner.nextLine();

        StringUtils.validateNumber(value);
        return Integer.parseInt(value);
    }

}
