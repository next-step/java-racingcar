package Racing.car;

import Racing.score.ScoreList;
import Racing.stage.Stage;
import Racing.type.RacingString;

public class Car {

  private ScoreList scoreList;

  public Car() {
    scoreList = new ScoreList();
  }

  public Car move(Stage stage) {
    scoreList.addScore(stage);
    return this;
  }

  public RacingString presentDistance() {
    return scoreList.showDisplay();
  }

  public RacingString presentDistance(Stage stage) {
    return scoreList.getScore(stage).showDisplay();
  }

}
