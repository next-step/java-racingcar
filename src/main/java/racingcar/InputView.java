package racingcar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int input(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }

}
