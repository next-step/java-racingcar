package racingcar.controller;

import racingcar.domain.car.Participants;
import racingcar.domain.racing.RacingGame;

public class RacingController {

    private static final String HEAD_MESSAGE = "\n실행 결과";
    private Participants participants;
    private final int turnCount;

    private RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turnCount = turn;
    }

    public static RacingController getInstance(Participants participants, int turn) {
        return new RacingController(participants, turn);
    }

    public void start() {
        System.out.println(HEAD_MESSAGE);
        RacingGame racingGame = new RacingGame(participants, turnCount);
        racingGame.game();
        racingGame.printRacingProcess();
        racingGame.printWinner();
    }
}
