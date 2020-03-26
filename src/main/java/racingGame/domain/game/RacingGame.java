package racingGame.domain.game;

import racingGame.domain.participant.Participants;
import racingGame.domain.participant.RoundScore;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Participants participants;
    private Round round;

    public RacingGame(String participants, int round) {
        this(new Participants(participants), round);
    }

    public RacingGame(Participants participants, int round) {
        this.participants = participants;
        this.round = new Round(round);
    }

    public GameResult start(MovingRule movingRule) {
        List<RoundScore> result = new ArrayList<>();
        for (int i = 0; i < round.getRound(); i++) {
            result.add(participants.startRound(movingRule));
        }
        return integrateGameResult(result);
    }

    private GameResult integrateGameResult(List<RoundScore> result) {
        return new GameResult(participants.getWinners(), result);
    }
}
