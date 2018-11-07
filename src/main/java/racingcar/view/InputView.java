package racingcar.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String getInputString(String message) {
        System.out.println(message);
        return scanner.next();
    }

    public int getInputNumber(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
