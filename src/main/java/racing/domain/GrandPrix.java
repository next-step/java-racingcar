package racing.domain;

import lombok.Getter;

@Getter
public class GrandPrix {
    private int id;
    private final int maxRounds;
    private final LineUp lineUp;
    private int currentRound = 0;

    public GrandPrix(LineUp lineUp, int maxRounds) {
        this.maxRounds = maxRounds;
        this.lineUp = lineUp;
    }

    public void runRound() {
        if (currentRound >= maxRounds) {
            return;
        }
        currentRound++;
        lineUp.runRound();
    }

    public void runFullRace() {
        while (currentRound < maxRounds) {
            runRound();
        }
    }

    public void setId(int id) {
        this.id = id;
    }
}
