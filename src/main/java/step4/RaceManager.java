package step4;

public class RaceManager {

    private final MovableStrategy movableStrategy;

    public RaceManager(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public void startRace() {
        RaceInput raceInput = new RaceInput();
        Race race = new Race(raceInput.numberOfTries(), raceInput.nameOfCars(), this.movableStrategy);
        RaceOutput raceOutput = new RaceOutput();
        while (race.isInRace()) {
            race.proceed();
            raceOutput.printRoundResult(race.cars());
            race.nextRound();
        }
        raceOutput.printWinners(race.cars());
    }
}
