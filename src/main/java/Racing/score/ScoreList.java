package Racing.score;

import Racing.stage.Stage;
import Racing.type.RacingString;

import java.util.ArrayList;
import java.util.List;

public class ScoreList {

    private List<Score> scores = new ArrayList<>();

    public Score addScore(Stage stage) {
        Score score = new Score(stage);
        scores.add(score);
        return score;
    }

    public RacingString showDisplay() {
        return scores.stream()
                .map(Score::showDisplay)
                .collect(RacingString.joining());
    }
}
