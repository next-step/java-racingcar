package study.racingcar.domain.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private final List<ScoreEachRound> grids;

    public ScoreBoard() {
        this.grids = new ArrayList<>();
    }

    public void score(ScoreEachRound scoreEachRound) {
        this.grids.add(scoreEachRound);
    }

    public List<ScoreEachRound> grids(){
        return this.grids;
    }

}
