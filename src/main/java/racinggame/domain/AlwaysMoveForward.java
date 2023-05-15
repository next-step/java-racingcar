package racinggame.domain;

public class AlwaysMoveForward implements MoveStrategy {
    @Override
    public boolean movable() {
        return true;
    }
    
}
