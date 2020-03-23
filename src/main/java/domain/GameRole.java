package domain;

public class GameRole {

    private int numberOfAttempts;
    private int numberOfCars;

    public GameRole(int numberOfCars, int numberOfAttempts) {
        this.numberOfCars = numberOfCars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }
}
