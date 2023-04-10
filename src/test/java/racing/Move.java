package racing;

public class Move implements MoveStrategy {

    public static final int MOVE = 1;

    @Override
    public Integer move() {
        return MOVE;
    }

}
