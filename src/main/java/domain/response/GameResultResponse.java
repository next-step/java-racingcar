package domain.response;

import java.util.List;

import domain.game.RacingResult;

public class GameResultResponse {
    private List<String[]> gameResult;

    public GameResultResponse(RacingResult racingResult) {
        this.gameResult = racingResult.getRacingResult();
    }

    public List<String[]> getGameResult() {
        return gameResult;
    }

}
