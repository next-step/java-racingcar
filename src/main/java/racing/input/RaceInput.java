package racing.input;

public class RaceInput {

    private final RaceLineUp raceLineUp;
    private final RaceAttempt attemptNumber;

    public RaceInput(String raceLineupInput, int numOfAttempt) {
        this.raceLineUp = RaceLineUp.of(raceLineupInput);
        this.attemptNumber = RaceAttempt.of(numOfAttempt);
    }

    public RaceLineUp raceLineUp() {
        return raceLineUp;
    }

    public RaceAttempt attemptNumber() {
        return attemptNumber;
    }
}
