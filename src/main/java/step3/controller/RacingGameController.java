package step3.controller;

import step3.repository.GameHistory;
import step3.domain.GameRound;
import step3.domain.Participant;
import step3.service.GameService;
import step3.service.RandomIntNumberGenerator;

public class RacingGameController {
    private GameRound gameRound;
    private Participant participant;
    private GameService gameService;

    private RacingGameController() {
    }

    private RacingGameController(int round, String names) {
        this.gameRound = GameRound.create(round);
        this.participant = Participant.join(names);
        this.gameService = GameService.create(new RandomIntNumberGenerator());
    }

    public static RacingGameController create(int round, String names) {
        return new RacingGameController(round, names);
    }

    public GameHistory start() {
        return gameService.start(gameRound, participant);
    }
}
