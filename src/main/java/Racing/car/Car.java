package Racing.car;

import Racing.score.Score;
import Racing.score.ScoreList;
import Racing.stage.Stage;
import Racing.type.RacingNumber;

public class Car {

  private final ScoreList scoreList;

  public Car() {
    scoreList = new ScoreList();
  }

  public Car move(Score score) {
    scoreList.addScore(score);
    return this;
  }

  public RacingNumber presentDistance() {
    return scoreList.showDisplay();
  }

  public RacingNumber presentDistance(Stage stage) {
    return scoreList.getScore(stage);
  }

}
