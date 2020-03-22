package racingGame.game;

import racingGame.car.Car;

import java.util.List;

public class TotalGameResult {
    private List<Car> winners;
    private List<GameResult> gameResults;

    public TotalGameResult(List<Car> winners, List<GameResult> gameResults) {
        this.winners = winners;
        this.gameResults = gameResults;
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
