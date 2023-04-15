package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final List<Integer> scoreList;

    public Score(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    public List<Integer> getScoreList() {
        return new ArrayList<>(scoreList);
    }
}
