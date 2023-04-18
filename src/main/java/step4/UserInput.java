package step4;

public class UserInput {

    private final String carNames;
    private final int numberOfRounds;

    public UserInput(String carNames, int numberOfRounds) {
        this.carNames = carNames;
        this.numberOfRounds = numberOfRounds;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}
