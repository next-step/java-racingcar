package racinggame.domain.scoreboard;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.car.Cars;
import racinggame.domain.exception.InvalidRoundException;

public class ScoreBoard {

    private final List<Score> scoredBoard = new ArrayList<>();

    public void recordScore(Cars cars) {
        Score score = new Score();
        score.recordScore(cars);
        scoredBoard.add(score);
    }

    public Score getScore(int round) {
        try {
            return scoredBoard.get(round - 1);
        } catch (Exception e) {
            throw new InvalidRoundException();
        }
    }

    public List<String> getWinner(int round) {
        return getScore(round)
                .getWinner();
    }

    public int getCountOfRound() {
        return scoredBoard.size();
    }
}
