package step3;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public int inputCarCount() {
        return scanner.nextInt();
    }

    public int inputMoveCount() {
        return scanner.nextInt();
    }
}
