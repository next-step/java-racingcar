package step3;

public class UserInput {

    private final int numberOfCars;
    private final int numberOfRounds;

    public UserInput(int numberOfCars, int numberOfRounds) {
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}
