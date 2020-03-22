package racingGame.game;

import racingGame.participant.RoundScore;
import racingGame.participant.Participants;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingGameRule racingGameRule;
    private Participants participants;
    private int round;

    public RacingGame(RacingGameRule racingGameRule) {
        this.racingGameRule = racingGameRule;
    }

    public void participate(Participants Participants, int gameCount) {
        verifyParticipate(Participants, gameCount);
        this.participants = Participants;
        this.round = gameCount;
    }

    private void verifyParticipate(Participants Participants, int gameCount) {
        if (Participants == null) {
            throw new IllegalArgumentException();
        }
        if (gameCount < 0) {
            throw new IllegalArgumentException();
        }
    }

    public GameResult start() {
        verifyParticipate(participants, round);
        List<RoundScore> result = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            participants.gameStart(racingGameRule);
            result.add(participants.getRoundScore());
        }
        return integrateGameResult(result);
    }

    private GameResult integrateGameResult(List<RoundScore> result) {
        return new GameResult(participants.getWinners(), result);
    }
}
