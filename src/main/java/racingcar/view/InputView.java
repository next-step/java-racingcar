package racingcar.view;

import racingcar.constant.RacingMessage;

import java.util.Scanner;

import static racingcar.util.Printer.display;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        display(RacingMessage.INPUT_CAR_COUNT);
        return scanner.nextInt();
    }

    public static int inputRound() {
        display(RacingMessage.INPUT_ROUND);
        return scanner.nextInt();
    }
}
