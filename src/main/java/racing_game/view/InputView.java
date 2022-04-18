package racing_game.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputValueWithMessage(String message) {
        ResultView.printMessage(message);

        return inputValue();
    }

    public static String inputValue() {

        return SCANNER.next();
    }
}
