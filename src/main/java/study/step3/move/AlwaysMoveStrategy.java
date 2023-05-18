package study.step3.move;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean isSuccess() {
        return true;
    }
}
