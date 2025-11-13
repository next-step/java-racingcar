package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {
    private final List<RoundResult> rounds = new ArrayList<>();

    public void record(RoundResult roundResult) {
        this.rounds.add(roundResult);
    }

    public List<RoundResult> getRounds() {
        return List.copyOf(this.rounds);
    }

    public List<String> winners() {
        return lastRound().findLeaders();
    }

    private RoundResult lastRound() {
        if (rounds.isEmpty()) {
            throw new IllegalStateException("경주 기록이 존재하지 않습니다.");
        }

        return rounds.getLast();
    }
}
