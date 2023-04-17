package racingcar;

public class UserInput {
    private final String numOfCars;
    private final String numOfTries;

    public UserInput(String numOfCars, String numOfTries) {
        this.numOfCars = numOfCars;
        this.numOfTries = numOfTries;
    }

    public int numOfTriesByInt() {
        return Integer.parseInt(numOfTries);
    }

    public int numOfCarsByInt() {
        return Integer.parseInt(numOfCars);
    }
}
