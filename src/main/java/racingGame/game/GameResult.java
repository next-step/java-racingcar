package racingGame.game;

import racingGame.car.Car;
import racingGame.participant.RoundScore;

import java.util.List;

public class GameResult {
    private List<Car> winners;
    private List<RoundScore> roundScores;

    public GameResult(List<Car> winners, List<RoundScore> roundScores) {
        this.winners = winners;
        this.roundScores = roundScores;
    }

    public List<RoundScore> getRoundScores() {
        return roundScores;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
