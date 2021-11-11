package step3.domain;

import step3.domain.history.GameHistory;
import step3.service.RandomIntNumberGenerator;
import step3.view.ResultView;

public class RacingGame {
    private GameRound round;
    private Participant participant;

    private RacingGame() {
    }

    private RacingGame(int round, String names) {
        this.round = GameRound.create(round, new RandomIntNumberGenerator());
        this.participant = Participant.join(names);
    }

    public static RacingGame create(int round, String names) {
        return new RacingGame(round, names);
    }

    public void start() {
        ResultView.start();
        GameHistory gameHistory = round.start(participant);
        ResultView.result(gameHistory);
    }
}
