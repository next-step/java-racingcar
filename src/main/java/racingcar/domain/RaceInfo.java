package racingcar.domain;

public class RaceInfo {
    private int currentRound;

    private final int maxRound;

    public RaceInfo(RaceInput raceInput) {
        this.currentRound = 0;
        this.maxRound = raceInput.getTryCount();
    }

    public void addCurrentRound() {
        this.currentRound++;
    }

    public boolean raceAvailable() {
        return maxRound > currentRound;
    }
}
