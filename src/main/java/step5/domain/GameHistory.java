package step5.domain;

import step5.exception.RacingGameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameHistory {

    private final List<GameRound> gameResult;

    public GameHistory() {
        gameResult = new ArrayList<>();
    }

    public void add(GameRound gameRound) {
        gameResult.add(gameRound);
    }

    public GameRound finalRound() {
        checkGameStarted();
        int totalRound = gameResult.size();
        return gameResult.get(totalRound - 1);
    }

    private void checkGameStarted() {
        if (gameResult.isEmpty()) {
            throw new RacingGameException("아직 게임을 진행하지 않았습니다");
        }
    }

    public List<GameRound> totalResult() {
        checkGameStarted();
        return Collections.unmodifiableList(gameResult);
    }

}
