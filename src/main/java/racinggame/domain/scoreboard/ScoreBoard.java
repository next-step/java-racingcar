package racinggame.domain.scoreboard;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.car.Cars;
import racinggame.domain.exception.OutOfRoundException;

public class ScoreBoard {

    private final List<Score> scoredBoard = new ArrayList<>();

    public void recordScore(Cars cars) {
        scoredBoard.add(new Score(cars));
    }

    public Score getScore(int round) {
        validateNumOfRound(round);
        return scoredBoard.get(round - 1);
    }

    private void validateNumOfRound(int round) {
        if (round <= 0 || round > scoredBoard.size()) {
            throw new OutOfRoundException();
        }
    }

    public List<String> getWinner(int round) {
        return getScore(round).getWinner();
    }

    public int getCountOfRound() {
        return scoredBoard.size();
    }
}
