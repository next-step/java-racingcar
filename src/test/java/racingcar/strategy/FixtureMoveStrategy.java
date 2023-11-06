package racingcar.strategy;

public class FixtureMoveStrategy implements MoveStrategy {

    private final int moveNumber;

    public FixtureMoveStrategy(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    @Override
    public int move() {
        return moveNumber;
    }
}
