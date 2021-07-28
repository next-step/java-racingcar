package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String MESSAGE_INPUT_TRY_COUNT = "시도할 회수는 몇 회인가요?";

    private InputView() {
    }

    public static String getCarNames() {
        System.out.println(MESSAGE_INPUT_CAR_NAMES);
        return inputCarNamesFromUser();
    }

    public static int getTryCount() {
        System.out.println(MESSAGE_INPUT_TRY_COUNT);
        return inputNumberFromUser();
    }

    private static int inputNumberFromUser() {
        return SCANNER.nextInt();
    }

    private static String inputCarNamesFromUser() {
        return SCANNER.next();
    }

}
