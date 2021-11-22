package Racing.score;

import Racing.stage.Stage;
import Racing.type.RacingString;
import java.util.ArrayList;
import java.util.List;

public class ScoreList {

  private List<Score> scores = new ArrayList<>();

  public Score addScore(Score score) {
    scores.add(score);
    return score;
  }

  public RacingString showDisplay() {
    return scores.stream()
        .map(Score::showDisplay)
        .collect(RacingString.joining());
  }

  public Score getScore(Stage stage) {
    return scores.stream()
        .filter((score -> score.isSameStage(stage)))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException());
  }
}
