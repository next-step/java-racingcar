package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<Round> rounds;

    GameResult() {
        this.rounds = new ArrayList<>();
    }

    void addRound(Round round) {
        rounds.add(round);
    }

    List<Round> getRounds() {
        return rounds;
    }

    Winners getWinners() {
        return getLastRound().getWinners();
    }

    private Round getLastRound() {
        return rounds.get(rounds.size() - 1);
    }

    int countRoundLength() {
        return rounds.size();
    }
}
