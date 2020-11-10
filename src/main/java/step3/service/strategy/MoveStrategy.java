package step3.service.strategy;

import step3.service.Randomize;
import step3.service.ScoreInspector;

/**
 * Created By mand2 on 2020-11-10.
 */
public abstract class MoveStrategy {

    Randomize randomize;
    ScoreInspector scoreInspector;

    public MoveStrategy() {}

    public MoveStrategy(Randomize randomize, ScoreInspector scoreInspector) {
        this.randomize = randomize;
        this.scoreInspector = scoreInspector;
    }

    public abstract int move();

}
