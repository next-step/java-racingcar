package racingcargame.view;

import java.util.Scanner;
import racingcargame.domain.common.Names;

public class InputView {

    private final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String ROUND_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static Names inputCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = scanner.nextLine();

        return new Names(input, ",");
    }

    public static int inputRoundCount() {
        System.out.println(ROUND_COUNT_INPUT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
