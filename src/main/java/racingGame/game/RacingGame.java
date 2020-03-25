package racingGame.game;

import racingGame.participant.Participants;
import racingGame.participant.RoundScore;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final MovingRule movingRule;
    private Participants participants;
    private int round;

    public RacingGame(MovingRule movingRule) {
        this.movingRule = movingRule;
    }

    public void participate(Participants participants, int round) {
        verifyParticipate(participants, round);
        this.participants = participants;
        this.round = round;
    }

    private void verifyParticipate(Participants Participants, int round) {
        if (Participants == null) {
            throw new IllegalArgumentException();
        }
        if (round < 0) {
            throw new IllegalArgumentException();
        }
    }

    public GameResult start() {
        verifyParticipate(participants, round);
        List<RoundScore> result = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            result.add(participants.startRound(movingRule));
        }
        return integrateGameResult(result);
    }

    private GameResult integrateGameResult(List<RoundScore> result) {
        return new GameResult(participants.getWinners(), result);
    }
}
