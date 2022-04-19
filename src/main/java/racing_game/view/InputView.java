package racing_game.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputString(String message) {
        ResultView.printMessage(message);

        return SCANNER.next();
    }

    public static int inputInteger(String message) {
        ResultView.printMessage(message);

        return SCANNER.nextInt();
    }
}
