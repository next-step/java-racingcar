package racingcar.controller;

import racingcar.domain.car.Participants;
import racingcar.domain.racing.RacingGame;

public class RacingController {

    private Participants participants;
    private final int turnCount;
    private String rp;
    private String winner;

    private RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turnCount = turn;
    }

    public static RacingController getInstance(Participants participants, int turn) {
        return new RacingController(participants, turn);
    }

    public void start() {
        RacingGame racingGame = new RacingGame(participants, turnCount);
        racingGame.game();

        rp = racingGame.getRacingProcess();
        winner = racingGame.getWinner();
    }

    public String getRacingProcess() {
        return this.rp;
    }

    public String getWinner() {
        return this.winner;
    }
}
