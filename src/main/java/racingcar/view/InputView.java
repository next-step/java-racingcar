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
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();

        return Arrays.asList(value.split(","));
    }

    public static int getAttemptNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String value = scanner.nextLine();

        StringUtils.validateNumber(value);
        return Integer.parseInt(value);
    }

}
