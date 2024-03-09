package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputtedNumber(String message) {
        System.out.println(message);

        try {
            return scanNextInt();
        } catch (InputMismatchException e) {
            return inputtedNumber(INPUT_NUMBER_MESSAGE);
        }

    }

    private int scanNextInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void closeScanner() {
        scanner.close();
    }
}
