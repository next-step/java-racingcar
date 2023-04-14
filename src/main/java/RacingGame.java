public class RacingGame {
    private final int numberOfCars;
    private final int numberOfRounds;


    public RacingGame(int numberOfCars, int numberOfRounds) {
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
