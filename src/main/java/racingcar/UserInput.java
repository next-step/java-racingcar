package racingcar;

public class UserInput {
    private final String[] carNames;
    private final String numOfTries;

    public UserInput(String[] carNames, String numOfTries) {
        this.carNames = carNames;
        this.numOfTries = numOfTries;
    }

    public String[] carNames() {
        return carNames;
    }

    public String numOfTries() {
        return numOfTries;
    }

    public int numOfTriesByInt() {
        return Integer.parseInt(numOfTries);
    }

    public int numOfCarsByInt() {
        return carNames.length;
    }
}
