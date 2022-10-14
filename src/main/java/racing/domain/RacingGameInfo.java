package racing.domain;

import racing.UserInputException;

public class RacingGameInfo {

    public int carCount;
    public int tryCount;

    public RacingGameInfo(String carInput, String tryInput) {
        this.carCount = inputValidation(carInput);
        this.tryCount = inputValidation(tryInput);
    }

    private int inputValidation(String input) {
        int number = UserInputException.isValidForNumber(input);
        return number;
    }
}