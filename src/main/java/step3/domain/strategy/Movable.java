package step3.domain.strategy;

/**
 * Created By mand2 on 2020-11-10.
 */
public class Movable extends MoveStrategy {

    @Override
    public int move() {
        return this.scoreInspector.judgeMovable(this.randomize);
    }
}
