package race;

import java.util.Scanner;

public class InputView {
    public static String inputCarName() {
        ResultView.printCarNamesRequestMessage();
        return getInputString();
    }

    public static int inputGameCount() {
        ResultView.printGameCountRequestMessage();
        return getInputInteger();
    }

    private static int getInputInteger() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
