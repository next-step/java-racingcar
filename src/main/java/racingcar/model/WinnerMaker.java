package racingcar.model;

public class WinnerMaker {

    private final Winner winner;
    public WinnerMaker() {
        this.winner = new Winner();
    }

    public Winner choiceWinner(RaceResult raceResult) {
        CarRecord finalRaceCarRecord = raceResult.getFinalRaceResult();

    }
}
