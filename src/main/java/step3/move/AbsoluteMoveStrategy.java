package step3.move;

public class AbsoluteMoveStrategy implements MoveStrategy{
    private static final int distance = 1;

    @Override
    public int moveAmount() {
        return distance;
    }
}
