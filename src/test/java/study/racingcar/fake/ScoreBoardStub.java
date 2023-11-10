package study.racingcar.fake;

import java.util.ArrayList;
import java.util.List;
import study.racingcar.ScoreBoard;
import study.racingcar.ScoreEachRound;

public class ScoreBoardStub extends ScoreBoard {

    private final List<ScoreEachRound> fakeScores;

    public ScoreBoardStub() {
        this.fakeScores = new ArrayList<>();
    }

    @Override
    public void score(ScoreEachRound scoreEachRound) {
        fakeScores.add(scoreEachRound);
    }

    @Override
    public List<ScoreEachRound> grids() {
        return fakeScores;
    }
}
