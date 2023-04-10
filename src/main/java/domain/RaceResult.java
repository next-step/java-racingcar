package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceResult {
    List<GameResult> gameResults;

    RaceResult() {
        gameResults = new ArrayList<>();
    }

    RaceResult(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public List<GameResult> getGames() {
        return new ArrayList<>(gameResults);
    }

    public void add(GameResult gameResult) {
        gameResults.add(gameResult);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RaceResult))
            return false;
        return Objects.equals(this.gameResults, ((RaceResult) obj).gameResults);
    }

    @Override
    public String toString() {
        return gameResults.toString();
    }
}
