package racingcar.param;

public class RacingCarInitParam {
    private final int numberOfCars;
    private final int totalRound;

    private RacingCarInitParam(int numberOfCars, int totalRound) {
        this.numberOfCars = numberOfCars;
        this.totalRound = totalRound;
    }

    public static RacingCarInitParam of(int numberOfCars, int totalRound) {
        return new RacingCarInitParam(numberOfCars, totalRound);
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTotalRound() {
        return totalRound;
    }
}
