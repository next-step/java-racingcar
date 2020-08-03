package racingcar;

public class UserArguments {
    private final int numberOfCars;
    private final int numberOfTrials;

    public UserArguments(int numberOfCars, int numberOfTrials) {
        this.numberOfCars = numberOfCars;
        this.numberOfTrials = numberOfTrials;
    }

    public static UserArguments createUserArgs(int numberOfCars, int numberOfTrials) {
        return new UserArguments(numberOfCars, numberOfTrials);
    }

    public int getNumberOfCars() {
        return this.numberOfCars;
    }

    public int getNumberOfTrials() {
        return this.numberOfTrials;
    }
}
