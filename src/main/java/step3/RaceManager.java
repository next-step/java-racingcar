package step3;

public class RaceManager {

    private final MovableStrategy movableStrategy;

    public RaceManager(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public void startRace() {
        RaceInput raceInput = new RaceInput();
        Race race = new Race(raceInput.numberOfTry(), raceInput.numberOfCar(), this.movableStrategy);
        RaceOutput raceOutput = new RaceOutput();
        while (race.isInRace()) {
            race.proceed();
            raceOutput.print(race.cars());
            race.nextRound();
        }
    }
}
