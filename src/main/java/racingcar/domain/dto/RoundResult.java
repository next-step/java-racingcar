package racingcar.domain.dto;

import java.util.List;

public class RoundResult {
    private final List<RoundScore> roundScores;

    public RoundResult(List<RoundScore> roundScores) {
        this.roundScores = roundScores;
    }

    public List<RoundScore> getRoundScores() {
        return roundScores;
    }
}
