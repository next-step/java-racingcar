package step3.domain;

public class AlwaysMoveStrategy implements MoveStrategy {

    @Override
    public boolean move() {
        return true;
    }
}
