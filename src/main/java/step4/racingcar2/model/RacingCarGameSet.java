package step4.racingcar2.model;

public class RacingCarGameSet {

    private final RacingCarGameRound[] gameRounds;

    public RacingCarGameSet(RacingCarGameRound[] gameRounds) {
        this.gameRounds = gameRounds;
    }

    public RacingCarGameRound[] gameRounds() {
        return this.gameRounds;
    }

}
