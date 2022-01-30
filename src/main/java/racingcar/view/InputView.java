package racingcar.view;

import racingcar.common.exception.InputValidationException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static racingcar.common.SystemMessage.*;

public class InputView {

    private static final String DELIMITER = ",";

    private String carNameInput;
    private List<String> splitUserInput;
    private int racingTime;
    private static final Scanner scanner = new Scanner(System.in);
    private boolean isAbNormalCarsName = true;
    private boolean isAbNormalRacingTime = true;


    private InputView() {
    }

    public static InputView instance() {
        return new InputView();
    }

    public void processConsoleInput() {
        while (!ProgressingConsole.isContinue(
            new ProgressingConsole(isAbNormalCarsName, isAbNormalRacingTime))) {
            parsingCarName();
            parsingRacingTime();
        }
    }

    private void parsingCarName() {
        try {
            System.out.println(CAR_NAME_INPUT_INFO);
            this.carNameInput = scanner.next();
            this.splitUserInput = splitStr(carNameInput);
            Validator.validateLengthLimit(splitUserInput);
            Validator.validateDuplicateCar(splitUserInput);
        } catch (InputValidationException exception) {
            isAbNormalCarsName = true;
            exception.printStackTrace();
        }
        isAbNormalCarsName = false;
    }

    private void parsingRacingTime() {
        try {
            System.out.println(RACING_TIME_INPUT_INFO);
            racingTime = scanner.nextInt();

        } catch (InputValidationException exception) {
            isAbNormalRacingTime = true;
            exception.printStackTrace();
        }
        isAbNormalRacingTime = false;
    }

    private List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER)).collect(Collectors.toList());
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public int getRacingTime() {
        return racingTime;
    }
}
