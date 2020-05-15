package step3.racingcar;

import java.util.Scanner;

public class InputViewProcessor {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int INPUT_LIMIT = 1;

    private InputViewProcessor() {
    }

    public static int getUserInput(String instructionMessage) {
        System.out.println(instructionMessage);
        int userInput = scanUserInput();
        validateUserInput(userInput);
        return userInput;
    }

    private static int scanUserInput() {
        return scanner.nextInt();
    }

    private static void validateUserInput(int userInput) {
        if (userInput < INPUT_LIMIT)
            throw new IllegalArgumentException(Message.ERROR);
    }
}
