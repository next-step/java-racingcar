package racingcar;

import lombok.Getter;

@Getter
public class UserInput {
    private final String[] carNames;
    private final String numOfTries;

    public UserInput(String[] carNames, String numOfTries) {
        this.carNames = carNames;
        this.numOfTries = numOfTries;
    }

    public int numOfTriesByInt() {
        return Integer.parseInt(numOfTries);
    }

    public int numOfCarsByInt() {
        return carNames.length;
    }
}
