package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String NAME_OF_THE_CARS_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)을 기준으로 구분).";
    private static final String RACING_TIMES_PROMPT = "시도할 회수는 몇 회 인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String inputCarNames() {
        System.out.println(NAME_OF_THE_CARS_PROMPT);

        return SCANNER.nextLine();
    }

    public static int inputNumberOfAttempts() {
        System.out.println(RACING_TIMES_PROMPT);
        return SCANNER.nextInt();
    }
}
