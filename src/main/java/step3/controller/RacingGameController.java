package step3.controller;

import step3.domain.GameRound;
import step3.domain.Participant;
import step3.service.HistoryService;
import step3.service.RandomIntNumberGenerator;
import step3.view.ResultView;

public class RacingGameController {
    private GameRound round;
    private Participant participant;

    private RacingGameController() {
    }

    private RacingGameController(int round, String names) {
        this.round = GameRound.create(round, new RandomIntNumberGenerator());
        this.participant = Participant.join(names);
    }

    public static RacingGameController create(int round, String names) {
        return new RacingGameController(round, names);
    }

    public void start() {
        ResultView.start();
        HistoryService gameHistory = round.start(participant);
        ResultView.result(gameHistory);
    }
}
