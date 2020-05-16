package step4;

import java.util.Scanner;

public class InputView {
    Scanner scanner;

    public InputView() {
        scanner  = new Scanner(System.in);
    }

    public String enterCarNames() {
        return scanner.nextLine();
    }

    public int enterTryCount() {
        return scanner.nextInt();
    }
}
