package racing.view;

import java.util.Scanner;

public class TerminalInputView {

    private TerminalInputView() {}

    public static int inputNumberOfCar() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return inputNextIntToSystemInScanner();
    }

    public static int inputNumberOfMove() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return inputNextIntToSystemInScanner();
    }

    private static int inputNextIntToSystemInScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
