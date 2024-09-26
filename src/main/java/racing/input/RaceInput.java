package racing.input;

public class RaceInput {

    private final int numOfCar;
    private final int numOfAttempt;

    public RaceInput(int numOfCar, int numOfAttempt) {
        this.numOfCar = numOfCar;
        this.numOfAttempt = numOfAttempt;
    }

    public int getNumOfCar() {
        return numOfCar;
    }

    public int getNumOfAttempt() {
        return numOfAttempt;
    }
}
