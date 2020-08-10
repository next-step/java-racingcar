package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        DisplayText.INPUT_CAR_NAMES.printMessage();
        return scanner.nextLine();
    }

    public static int getRound() {
        DisplayText.INPUT_ROUND_NUMBER.printMessage();
        return Integer.valueOf(scanner.nextLine());
    }
}
