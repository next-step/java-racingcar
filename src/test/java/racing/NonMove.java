package racing;

public class NonMove implements MoveStrategy {

    public static final int NON_MOVE = 0;

    @Override
    public Integer move() {
        return NON_MOVE;
    }

}
