package racingcar;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(DefaultMessages.INPUT_CAR_NAMES);
        return scanner.nextLine();
    }

    public static String inputTryCount() {
        System.out.println(DefaultMessages.INPUT_TRY_COUNT);
        return scanner.nextLine();
    }
}
