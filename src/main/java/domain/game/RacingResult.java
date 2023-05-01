package domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingResult {

    private List<Map<String, Integer>> gameResults;

    public RacingResult() {
        this.gameResults = new ArrayList<>();
    }

    public void addEachRoundResult(Map<String, Integer> eachResult) {
        gameResults.add(eachResult);
    }

    public List<Map<String, Integer>> getGameResults() {
        return gameResults;
    }

}
