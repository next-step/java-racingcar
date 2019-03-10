package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    List<Round> rounds;

    public GameResult() {
        this.rounds = new ArrayList<>();
    }

    public void addRound(Round round) {
        rounds.add(round);
    }

    public int countRoundLength() {
        return rounds.size();
    }

    public Round getRound(int index) {
        return rounds.get(index);
    }
}
