package step3;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String readInput() {
        String input = this.scanner.nextLine();

        return input;
    }
}
