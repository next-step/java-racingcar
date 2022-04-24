package racingcar.domain;

import racingcar.domain.input.RoundCount;

public class Round {

    private final int INITIAL_ROUND = 1;

    private RoundCount totalRound;
    private RoundCount currentRound;

    public Round(RoundCount totalRound) {
        this.totalRound = totalRound;
        this.currentRound = new RoundCount(INITIAL_ROUND);
    }

    public Round(Round round) {
        this.totalRound = new RoundCount(round.totalRound);
        this.currentRound = new RoundCount(round.currentRound);
    }

    public void nextRound() {
        currentRound.up();
    }

    public boolean isOngoing() {
        if (currentRound.isBigger(totalRound)) {
            return false;
        }
        return true;
    }

    public RoundCount currentRound() {
        return this.currentRound;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Round)) {
            return false;
        }
        Round r = (Round) obj;
        return r.totalRound.equals(totalRound) && r.currentRound.equals(currentRound);
    }
}
