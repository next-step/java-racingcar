package study.racingcar;

import java.util.List;

public class ScoreEachRound {
    private final List<Score> roundScores;

    public ScoreEachRound(List<Score> roundScores) {
        this.roundScores = roundScores;
    }

    public List<Score> roundScores(){
        return this.roundScores;
    }
}
