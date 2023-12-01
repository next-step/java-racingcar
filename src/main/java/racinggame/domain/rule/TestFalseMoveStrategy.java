package racinggame.domain.rule;

public class TestFalseMoveStrategy implements MoveStrategy {
    @Override
    public boolean moveRule() {
        return false;
    }
}
