package study.step3;

public class RandomMoveStrategy implements MoveStrategy{
    @Override
    public boolean move() {
        return NumberChecker.checkCondition();
    }
}
