package step3.racingcar;

import java.util.Scanner;

public class InputViewProcessor {
    private InputViewProcessor() {
    }

    public static int getUserInput(String instructionMessage) {
        System.out.println(instructionMessage);
        int userInput = scanUserInput();
        validateUserInput(userInput);
        return userInput;
    }

    private static int scanUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void validateUserInput(int userInput) {
        if (userInput <= 0)
            throw new IllegalArgumentException(Message.ERROR);
    }
}
