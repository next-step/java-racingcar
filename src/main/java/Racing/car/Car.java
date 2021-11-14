package Racing.car;

import Racing.score.ScoreList;
import Racing.stage.Stage;

public class Car {


    private ScoreList score;

    public Car() {
        score = new ScoreList();
    }

    public Car move(Stage stage) {
        score.addScore(stage);
        return this;
    }

    public String presentDistance() {
        return score.showDisplay();
    }
}
