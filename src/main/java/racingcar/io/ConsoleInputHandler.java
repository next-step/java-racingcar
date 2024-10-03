package racingcar.io;

import racingcar.validation.UserInputValidator;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public int getCarCountFromUser() {
        String userInput = SCANNER.nextLine();
        UserInputValidator.numberInputValidate(userInput);
        return Integer.parseInt(userInput);
    }

    @Override
    public int getTrialCountFromUser() {
        String userInput = SCANNER.nextLine();
        UserInputValidator.numberInputValidate(userInput);
        return Integer.parseInt(userInput);
    }
}
