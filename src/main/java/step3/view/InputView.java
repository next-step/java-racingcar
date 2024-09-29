package step3.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getCarNumberFromUser() {
        return Integer.parseInt(scanner.nextLine());
    }

    public int getRoundNumberFromUser() {
        return Integer.parseInt(scanner.nextLine());
    }
}
