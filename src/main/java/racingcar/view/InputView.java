package racingcar.view;

import racingcar.constant.RacingMessage;

import java.util.Scanner;

import static racingcar.util.Printer.display;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String inputCars() {
        display(RacingMessage.INPUT_CAR_LIST);
        return scanner.nextLine();
    }

    public static int inputRound() {
        display(RacingMessage.INPUT_ROUND);
        return scanner.nextInt();
    }
}
