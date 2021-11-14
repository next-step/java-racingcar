package Racing.score;

import Racing.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreList {

    private List<Score> scores = new ArrayList<>();

    public Score addScore(Stage stage) {
        Score score = new Score(stage);
        scores.add(score);
        return score;
    }

    public String showDisplay() {
        return scores.stream()
                .map(Score::showDisplay)
                .collect(Collectors.joining());
    }
}
