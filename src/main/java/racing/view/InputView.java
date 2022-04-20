package racing.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputString(String message) {
        ResultView.printNewLineMessage(message);

        return SCANNER.next();
    }

    public static int inputInteger(String message) {
        ResultView.printNewLineMessage(message);

        return SCANNER.nextInt();
    }
}
