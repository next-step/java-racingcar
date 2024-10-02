package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRounds {
    private final List<GameResults> gameResults;

    public GameRounds() {
        this.gameResults = new ArrayList<>();
    }

    public void add(GameResults gameResults) {
        this.gameResults.add(gameResults);
    }

    public int getRoundCount() {
        return this.gameResults.size();
    }

    public int getCarCount(int roundIndex) {
        return gameResults.get(roundIndex).carCount();
    }

    public int getCarPosition(int roundIndex, int carIndex) {
        return gameResults.get(roundIndex).getGameResult(carIndex).getCarPosition();
    }

    public String getCarName(int roundIndex, int carIndex) {
        return gameResults.get(roundIndex).getGameResult(carIndex).getCarName();
    }

    public List<String> getWinner() {
        return gameResults.get(gameResults.size() - 1).getWinners();
    }
}