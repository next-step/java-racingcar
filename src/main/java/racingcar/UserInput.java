package racingcar;

public class UserInput {

    private int carNumber;
    private int runNumber;

    public UserInput(int carNumber, int runNumber) {
        this.carNumber = carNumber;
        this.runNumber = runNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getRunNumber() {
        return runNumber;
    }
}
