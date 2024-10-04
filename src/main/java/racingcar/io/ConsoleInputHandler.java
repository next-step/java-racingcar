package racingcar.io;

import racingcar.validation.UserInputValidator;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DEFAULT_DELIMITER = ",";

    @Override
    public String[] getCarNamesFromUser() {
        String userInput = SCANNER.nextLine();
        UserInputValidator.carNamesInputValidate(userInput, DEFAULT_DELIMITER);
        return toStringArray(userInput);
    }

    private String[] toStringArray(String userInput) {
        return userInput.split(DEFAULT_DELIMITER);
    }

    @Override
    public int getTrialCountFromUser() {
        String userInput = SCANNER.nextLine();
        UserInputValidator.numberInputValidate(userInput);
        return Integer.parseInt(userInput);
    }
}
