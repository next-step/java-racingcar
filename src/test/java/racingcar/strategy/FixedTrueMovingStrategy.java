package racingcar.strategy;

public class FixedTrueMovingStrategy implements MovingStrategy {

    @Override
    public boolean decideWhetherToMove() {
        return true;
    }
}
