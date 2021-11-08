package racinggame.domain;

public class RacingGame {

    private final Cars cars;
    private final Laps laps;

    public RacingGame(Integer carCount, Laps laps) {
        this.cars = new Cars(carCount);
        this.laps = laps;
    }

    public void startRacing() {
        while (!laps.isGoal()) {
            cars.roundRacing();
            laps.passStartLine();
        }
    }

    public Cars resultRacing() {
        return cars;
    }
}
