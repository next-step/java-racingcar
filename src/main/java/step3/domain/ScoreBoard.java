package step3.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By mand2 on 2020-11-09.
 */
public class ScoreBoard {

    private final String name;
    private List<Integer> scoreHistory;

    public ScoreBoard(String name) {
        this.name = name;
        this.scoreHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getScoreHistory() {
        return scoreHistory;
    }
}
