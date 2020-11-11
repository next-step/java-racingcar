package step3.domain.strategy;

import step3.domain.Randomize;
import step3.domain.ScoreInspector;

/**
 * Created By mand2 on 2020-11-10.
 */
public abstract class MoveStrategy {

    Randomize randomize;
    ScoreInspector scoreInspector;

    public MoveStrategy(Randomize randomize) {
        this.randomize = randomize;
        this.scoreInspector = new ScoreInspector();
    }

    public MoveStrategy(Randomize randomize, ScoreInspector scoreInspector) {
        this.randomize = randomize;
        this.scoreInspector = scoreInspector;
    }

    public abstract int move();

}
