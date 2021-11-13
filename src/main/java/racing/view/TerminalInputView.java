package racing.view;

import java.util.Scanner;

public class TerminalInputView {

    private TerminalInputView() {}

    public static int getNumberOfCarFromTerminalInput() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return getNextIntFromSystemInScanner();
    }

    public static int getNumberOfMoveFromTerminalInput() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return getNextIntFromSystemInScanner();
    }

    private static int getNextIntFromSystemInScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
