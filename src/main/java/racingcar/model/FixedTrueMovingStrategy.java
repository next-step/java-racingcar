package racingcar.model;

public class FixedTrueMovingStrategy implements MovingStrategy {

    @Override
    public boolean decideWhetherToMove() {
        return true;
    }
}
