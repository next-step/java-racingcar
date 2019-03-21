package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<Round> rounds;

    public GameResult() {
        this.rounds = new ArrayList<>();
    }

    public void addRound(Round round) {
        rounds.add(round);
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public Winners getWinners() {
        return getLastRound().getWinners();
    }

    public Round getLastRound() {
        return rounds.get(rounds.size() - 1);
    }

    public int countRoundLength() {
        return rounds.size();
    }
}
