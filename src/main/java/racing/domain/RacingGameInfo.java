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

    public static String[] split(String carName) {
        String[] carNames = carName.split(SPLIT_REGEX);
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = isValidForString(carNames[i]);
        }
        return carNames;
    }

    private int validationForNumber(String input) {
        int number = isValidForNumber(input);
        return number;
    }
}