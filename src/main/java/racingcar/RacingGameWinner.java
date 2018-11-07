package racingcar;

public class RacingGameWinner {
    private String name;

    private RacingGameWinner(RacingGameResultSet.RacingGameResult racingGameResult) {
        this.name = racingGameResult.getName();
    }

    public static RacingGameWinner of(RacingGameResultSet.RacingGameResult racingGameResult) {
        return new RacingGameWinner(racingGameResult);
    }

    public String getName() {
        return name;
    }
}
