package racingGame.game;

import racingGame.participant.GameResult;
import racingGame.participant.Participants;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingGameRule racingGameRule;
    private Participants participants;
    private TotalGameResult totalGameResult;
    private int gameCount;

    public RacingGame(RacingGameRule racingGameRule) {
        this.racingGameRule = racingGameRule;
    }

    public void participate(Participants Participants, int gameCount) {
        verifyParticipate(Participants, gameCount);
        this.participants = Participants;
        this.gameCount = gameCount;
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
        verifyParticipate(participants, gameCount);
        List<GameResult> result = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            participants.gameStart(racingGameRule);
            result.add(participants.getGameResult());
        }
        recordTotalGameResult(result);
    }

    private void recordTotalGameResult(List<GameResult> result) {
        totalGameResult = new TotalGameResult(participants.getWinners(), result);
    }

    public TotalGameResult getTotalGameResult() {
        if (totalGameResult == null) {
            throw new IllegalArgumentException();
        }
        return totalGameResult;
    }
}
