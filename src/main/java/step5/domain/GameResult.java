package step5.domain;

import step5.domain.dto.ResultOfCar;
import step5.exception.RacingGameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
    private List<GameRound> gameResult;

    public GameResult() {
        gameResult = new ArrayList<>();
    }

    public void add(GameRound gameRound) {
        gameResult.add(gameRound);
    }

    public List<ResultOfCar> finalResult() {
        checkGameStarted();
        int totalRound = gameResult.size();
        GameRound finalRound = gameResult.get(totalRound - 1);
        List<ResultOfCar> finalResults = finalRound.getGameRoundResult();
        return Collections.unmodifiableList(finalResults);
    }

    public List<GameRound> totalResult() {
        checkGameStarted();
        return Collections.unmodifiableList(gameResult);
    }

    private void checkGameStarted() {
        if (gameResult == null || gameResult.isEmpty()) {
            throw new RacingGameException("아직 게임을 진행하지 않았습니다");
        }
    }

}
