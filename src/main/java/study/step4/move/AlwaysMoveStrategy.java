package study.step4.move;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean isSuccess() {
        return true;
    }
}
