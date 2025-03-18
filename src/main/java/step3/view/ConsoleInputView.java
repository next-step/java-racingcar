package step3.view;

import java.util.Scanner;

public class ConsoleInputView extends AbstractInputView {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
