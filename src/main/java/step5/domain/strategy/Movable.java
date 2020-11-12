package step5.domain.strategy;

import step5.domain.Randomize;

/**
 * Created By mand2 on 2020-11-10.
 */
public class Movable extends MoveStrategy {

    @Override
    public int move() {
        return this.scoreInspector.judgeMovable(this.randomize);
    }

    public Movable(Randomize randomize) {
        super(randomize);
    }
}
