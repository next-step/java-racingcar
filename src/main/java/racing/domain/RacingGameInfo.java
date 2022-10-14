package racing.domain;

import racing.view.InputView;

import static racing.UserInputException.isValidForNumber;
import static racing.UserInputException.isValidForString;

public class RacingGameInfo {

    private static final String SPLIT_REGEX = ",";

    public int carCount;
    public int tryCount;
    public String[] carNames;

    public RacingGameInfo() {
        this.carNames = split(InputView.inputCarName());
        this.tryCount = isValidForNumber(InputView.inputTryCount());
    }

    public String[] split(String carName) {
        for (String name : carName.split(SPLIT_REGEX)) {
            isValidForString(name.trim());
        }
        return carName.split(SPLIT_REGEX);
    }

    private int validationForNumber(String input) {
        int number = isValidForNumber(input);
        return number;
    }

    private String validationForString(String input) {
        String name = isValidForString(input);
        return name;
    }
}