package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private final List<Score> scoreList;

    public ScoreBoard() {
        this.scoreList = new ArrayList<>();
    }

    public void score(Score score) {
        scoreList.add(score);
    }

    public List<Score> scoreList(){
        return scoreList;
    }

}
