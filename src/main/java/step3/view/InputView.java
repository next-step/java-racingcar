package step3.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getCarNumberFromUser() {
        String userInput = scanner.nextLine();
        return Integer.parseInt(userInput);
    }

    public int getRoundNumberFromUser() {
        String userInput = scanner.nextLine();
        return Integer.parseInt(userInput);
    }
}
