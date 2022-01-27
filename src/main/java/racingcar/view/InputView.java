package racingcar.view;

import racingcar.common.exception.InputValidationException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static racingcar.common.SystemMessage.*;

public class InputView {

    private static final String DELIMITER = ",";
    private static final int LENGTH_LIMIT_MAX = 5;
    private static final int LENGTH_LIMIT_MIN = 1;

    private String carNameInput;
    private List<String> splitUserInput;
    private int racingTime;
    private final Scanner scanner = new Scanner(System.in);


    private InputView() {
    }

    public static InputView instance() {
        return new InputView();
    }

    public void processConsoleInput() {
        while (parsingCarName())
            ;
        while (parsingRacingTime())
            ;
    }

    private boolean parsingCarName() {
        try {
            System.out.println(CAR_NAME_INPUT_INFO);
            this.carNameInput = scanner.next();
            this.splitUserInput = splitStr(carNameInput);
            validateLengthLimit(splitUserInput);
            validateDuplicateCar(splitUserInput);
        } catch (InputValidationException exception) {
            exception.printStackTrace();
            return true;
        }
        return false;
    }

    private boolean parsingRacingTime() {
        try {
            System.out.println(RACING_TIME_INPUT_INFO);
            racingTime = scanner.nextInt();

        } catch (InputValidationException exception) {
            exception.printStackTrace();
            return true;
        }
        return false;
    }

    private void validateLengthLimit(final List<String> splitUserInput) {
        boolean match = splitUserInput.stream()
            .allMatch(
                input -> input.length() <= LENGTH_LIMIT_MAX && input.length() >= LENGTH_LIMIT_MIN);

        if (!match) {
            throw new InputValidationException(CAR_NAME_LENGTH_LIMIT_ERROR);
        }
    }

    private void validateDuplicateCar(final List<String> splitUserInput) {
        int size = (int) splitUserInput.stream().distinct().count();

        if (size != splitUserInput.size()) {
            throw new InputValidationException(CAR_NAME_DUPLICATE_ERROR);
        }
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
