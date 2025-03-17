package racingcar.view;

import racingcar.message.ErrorMessage;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String readInput() {
        return scanner.nextLine().trim();
    }

    public int convertToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER + input);
        }
    }
}
