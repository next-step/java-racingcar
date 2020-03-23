package CarRacing;

public class RacingGame {

    final private RacingStrategy racingStrategy;
    final private RacingCars racingCars;
    final private int racingTime;

    public RacingGame(final int carCount, final int racingTime) {
        this.racingTime = racingTime;
        this.racingCars = new RacingCars(carCount);
        this.racingStrategy = new MovingStrategy();
    }

    public void raceStart() {
        for (int i = 0; i < this.racingTime; i++){
            this.racingCars.race(this.racingStrategy);
            this.racingCars.showCurrentStatus();
        }
    }
}
