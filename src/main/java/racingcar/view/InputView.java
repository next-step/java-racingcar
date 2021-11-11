package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int nextInt(String message) {
        OutputView.print(message);
        return SCANNER.nextInt();
    }

    public static String[] nextLineWithSplit(String message, String regex) {
        OutputView.print(message);
        return SCANNER.nextLine().split(regex);
    }
}
