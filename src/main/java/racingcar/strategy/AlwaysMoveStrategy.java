package racingcar.strategy;

public class AlwaysMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public boolean isMovable(int number) {
        return true;
    }

}
