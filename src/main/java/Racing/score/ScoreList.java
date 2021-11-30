package Racing.score;

import Racing.stage.Stage;
import Racing.type.RacingNumber;
import java.util.ArrayList;
import java.util.List;

public class ScoreList {

  private final List<Score> scores = new ArrayList<>();
  private final int FROM_INDEX = 0;
  private final int NUMBER_TO_INDEX = 1;

  public Score addScore(Score score) {
    scores.add(score);
    return score;
  }

  public RacingNumber showDisplay() {
    return scores.stream()
        .map(Score::getDistance)
        .collect(RacingNumber.summing());
  }

  public RacingNumber getScore(Stage stage) {
    Score targetScore = scores.stream()
        .filter((score -> score.isSameStage(stage)))
        .findAny()
        .orElseThrow(IllegalArgumentException::new);
    int index = scores.indexOf(targetScore);
    int toIndex = index + NUMBER_TO_INDEX;
    return scores.subList(FROM_INDEX, toIndex)
        .stream()
        .map(Score::getDistance)
        .reduce(RacingNumber.ZERO, RacingNumber::plus);
  }
}
