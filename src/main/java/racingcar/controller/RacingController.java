package racingcar.controller;

import racingcar.domain.car.Participants;
import racingcar.domain.racing.RacingGame;
import racingcar.domain.racing.RacingRecord;
import racingcar.view.OutputView;

public class RacingController {

    private final Participants participants;
    private final RacingRecord racingRecord;
    private final int turnCount;
    private String winner;

    private RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turnCount = turn;
        this.racingRecord = new RacingRecord();
    }

    public static RacingController getInstance(Participants participants, int turn) {
        return new RacingController(participants, turn);
    }

    public void start() {
        RacingGame racingGame = new RacingGame(participants, turnCount);
        winner = racingGame.gameStart(racingRecord).stream()
            .reduce((first, second) -> second)
            .orElseThrow(() -> new RuntimeException())
            .getWinner();
    }

    public void printGameResult() {
        OutputView.printRacingResult(getRacingProcess());
        OutputView.printWinner(winner);
    }

    public String getRacingProcess() {
        return racingRecord.getResultRecord();
    }
}
