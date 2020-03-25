package racingGame.domain.game;

import racingGame.domain.car.Car;
import racingGame.domain.participant.RoundScore;

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
