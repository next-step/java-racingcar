package racing_game.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputIntValueWithMessage(String message) {
        ResultView.printMessage(message);

        return inputIntValue();
    }

    public static int inputIntValue() {

        return SCANNER.nextInt();
    }
}
