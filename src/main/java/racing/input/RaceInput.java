package racing.input;

public class RaceInput {

    private final RaceLineup raceLineup;
    private final RaceAttempt attemptNumber;

    public RaceInput(String raceLineupInput, int numOfAttempt) {
        this.raceLineup = RaceLineup.of(raceLineupInput);
        this.attemptNumber = RaceAttempt.of(numOfAttempt);
    }

    public RaceLineup raceLineup() {
        return raceLineup;
    }

    public RaceAttempt attemptNumber() {
        return attemptNumber;
    }
}
