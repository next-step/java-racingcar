package racingcar.io;

import racingcar.car.CarName;
import racingcar.validation.UserInputValidator;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DEFAULT_DELIMITER = ",";

    @Override
    public CarName[] getCarNamesFromUser() {
        String userInput = SCANNER.nextLine();
        UserInputValidator.carNamesInputValidate(userInput, DEFAULT_DELIMITER);
        return toCarNameArray(userInput);
    }

    private CarName[] toCarNameArray(String userInput) {
        return Arrays.stream(getSplit(userInput))
                .map(CarName::of)
                .toArray(CarName[]::new);
    }

    private String[] getSplit(String userInput) {
        return userInput.split(DEFAULT_DELIMITER);
    }

    @Override
    public int getTrialCountFromUser() {
        String userInput = SCANNER.nextLine();
        UserInputValidator.numberInputValidate(userInput);
        return getAnInt(userInput);
    }

    private int getAnInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}
