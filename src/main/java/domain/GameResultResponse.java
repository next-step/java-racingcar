package domain;

import java.util.List;

public class GameResultResponse {
    private List<String[]> gameResult;
    public GameResultResponse(List<String[]> gameResult) {
        this.gameResult = gameResult;
    }

    public List<String[]> getGameResult() {
        return gameResult;
    }


}
