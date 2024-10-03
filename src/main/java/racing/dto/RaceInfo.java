package racing.dto;

public class RaceInfo {

    private final RaceLineUp raceLineUp;
    private final RaceAttempt attemptNumber;

    public RaceInfo(String raceLineupInput, int numOfAttempt) {
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
