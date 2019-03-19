package racingcar.view;

import racingcar.domain.Round;
import racingcar.domain.Winners;

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

    private Round getLastRound() {
        return rounds.get(rounds.size() - 1);
    }

    public int countRoundLength() {
        return rounds.size();
    }
}
