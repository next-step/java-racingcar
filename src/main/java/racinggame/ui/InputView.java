package racinggame.ui;

import java.util.Scanner;

import static racinggame.ui.MessageConstants.CAR_COUNT_QUESTION;
import static racinggame.ui.MessageConstants.NOT_INTEGER;
import static racinggame.ui.MessageConstants.ROUNDS_QUESTION;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("view view");
    }

    public static int promptCarCount() {
        System.out.println(CAR_COUNT_QUESTION);
        return scanNumber();
    }

    public static int promptRounds() {
        System.out.println(ROUNDS_QUESTION);
        return scanNumber();
    }

    private static int scanNumber() {
        while (!SCANNER.hasNextInt()) {
            SCANNER.next();
            System.err.print(NOT_INTEGER);
        }

        return SCANNER.nextInt();
    }

}
