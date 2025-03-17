package step3.racingcar.model;

public class RacingCarGameSet {

    private final RacingCarGameRound[] gameRounds;

    public RacingCarGameSet(RacingCarGameRound[] gameRounds) {
        this.gameRounds = gameRounds;
    }

    public RacingCarGameRound[] gameRounds() {
        return this.gameRounds;
    }

}
