package racingGame.game;

import racingGame.participant.RoundScore;
import racingGame.participant.Participants;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingGameRule racingGameRule;
    private Participants participants;
    private GameResult gameResult;
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

    public void start() {
        verifyParticipate(participants, round);
        List<RoundScore> result = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            participants.gameStart(racingGameRule);
            result.add(participants.getRoundScore());
        }
        recordTotalGameResult(result);
    }

    private void recordTotalGameResult(List<RoundScore> result) {
        gameResult = new GameResult(participants.getWinners(), result);
    }

    public GameResult getGameResult() {
        if (gameResult == null) {
            throw new IllegalArgumentException();
        }
        return gameResult;
    }
}
